package com.innowise.orderservice.service.impl;

import static com.innowise.orderservice.model.OrderStatus.PENDING;
import static java.util.Objects.nonNull;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.exception.RecordNotFoundException;
import com.innowise.orderservice.mapper.OrderMapper;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.repository.OrderRepository;
import com.innowise.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;

  @Override
  public OrderDto getOrder(String id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(RecordNotFoundException::new);
    return orderMapper.toDto(order);
  }

  @Override
  public Page<OrderDto> getOrderList(OrderStatus orderStatus, Pageable pageable) {
    Page<Order> orderDtoPage = resolveGetOrderList(orderStatus, pageable);
    return orderDtoPage.map(orderMapper::toDto);
  }

  private Page<Order> resolveGetOrderList(OrderStatus orderStatus, Pageable pageable) {
    if (nonNull(orderStatus)) {
      return orderRepository.findAllByOrderStatus(orderStatus, pageable);
    }
    return orderRepository.findAll(pageable);
  }

  @Override
  public Page<OrderDto> getOrderListByCustomerId(
      Long customerId, OrderStatus orderStatus, Pageable pageable) {
    return orderRepository
        .findAllByCustomerIdAndOrderStatus(customerId, orderStatus, pageable)
        .map(orderMapper::toDto);
  }

  @Override
  public Page<OrderDto> getOrderListByRestaurantId(
      Long restaurantId, OrderStatus orderStatus, Pageable pageable) {
    return orderRepository
        .findAllByRestaurantIdAndOrderStatus(restaurantId, orderStatus, pageable)
        .map(orderMapper::toDto);
  }

  @Override
  public Page<OrderDto> getOrderListByDeliveryManId(
      Long deliveryManId, OrderStatus orderStatus, Pageable pageable) {
    return orderRepository
        .findAllByDeliveryManIdAndOrderStatus(deliveryManId, orderStatus, pageable)
        .map(orderMapper::toDto);
  }

  @Override
  public Order createOrder(OrderDto orderDto) {
    Order order = orderMapper.toEntity(orderDto);
    order.setOrderStatus(PENDING);
    return orderRepository.save(order);
  }

  @Override
  public void updateOrder(String id, OrderDto orderDto) {
    if (!orderRepository.existsById(id)) {
      throw new RecordNotFoundException();
    }

    Order convertedOrder = orderMapper.toEntity(orderDto);
    convertedOrder.setId(id);

    orderRepository.save(convertedOrder);
  }

  @Override
  public void deleteOrder(String id) {
    if (!orderRepository.existsById(id)) {
      throw new RecordNotFoundException();
    }

    orderRepository.deleteById(id);
  }

  @Override
  public void updateOrderStatus(String id, OrderStatus orderStatus) { // todo fix
//    Order order = getOrder(id);
//    order.setOrderStatus(orderStatus);
//    orderRepository.save(order);
  }

}
