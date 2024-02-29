package com.innowise.orderservice.service.impl;

import static com.innowise.orderservice.model.OrderStatus.PENDING;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.mapper.OrderMapper;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.repository.OrderRepository;
import com.innowise.orderservice.service.OrderService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;

  @Override
  public Order getOrder(String id) {
    return orderRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
  }

  @Override
  public OrderDto getOrderDto(String id) {
    return orderMapper.toDto(getOrder(id));
  }

  @Override
  public List<Order> getOrderList(OrderStatus orderStatus, Integer pageNumber, Integer pageSize) {
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

    if (Objects.nonNull(orderStatus)) {
      return orderRepository.findAllByOrderStatus(orderStatus, pageRequest)
          .getContent();
    }

    return orderRepository.findAll(pageRequest)
        .getContent();
  }

  @Override
  public List<OrderDto> getOrderDtoList(OrderStatus orderStatus, Integer pageNumber, Integer pageSize) {
    return getOrderList(orderStatus, pageNumber, pageSize).stream()
        .map(orderMapper::toDto)
        .collect(Collectors.toList());
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
  public void updateOrderStatus(String id, OrderStatus orderStatus) {
    Order order = getOrder(id);
    order.setOrderStatus(orderStatus);
    orderRepository.save(order);
  }
}
