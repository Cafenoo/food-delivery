package com.innowise.orderservice.service.impl;

import static com.innowise.orderservice.model.OrderStatus.PENDING;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.mapper.OrderMapper;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.repository.OrderRepository;
import com.innowise.orderservice.service.OrderService;
import java.util.NoSuchElementException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;

  @Override
  public OrderDto getOrder(String id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    return orderMapper.toDto(order);
  }

  @Override
  public Page<OrderDto> getOrderList(
      OrderStatus orderStatus, Integer pageNumber, Integer pageSize) {

    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

    Page<Order> orderDtoPage;
    if (Objects.nonNull(orderStatus)) {
      orderDtoPage = orderRepository.findAllByOrderStatus(orderStatus, pageRequest);
    } else {
      orderDtoPage = orderRepository.findAll(pageRequest);
    }

    return orderDtoPage.map(orderMapper::toDto);
  }

  @Override
  public Order createOrder(OrderDto orderDto) {
    Order order = orderMapper.toEntity(orderDto);
    order.setOrderStatus(PENDING);
    return orderRepository.save(order);
  }

  @Override
  public void updateOrder(String id, OrderDto orderDto) {
    getOrder(id);
    Order convertedOrder = orderMapper.toEntity(orderDto);

    convertedOrder.setId(id);

    orderRepository.save(convertedOrder);
  }

  @Override
  public void deleteOrder(String id) {
    getOrder(id);
    orderRepository.deleteById(id);
  }

  @Override
  public void updateOrderStatus(String id, OrderStatus orderStatus) { // todo fix
//    Order order = getOrder(id);
//    order.setOrderStatus(orderStatus);
//    orderRepository.save(order);
  }
}
