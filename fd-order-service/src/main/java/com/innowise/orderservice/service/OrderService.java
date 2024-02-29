package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import java.util.List;

public interface OrderService {

  Order getOrder(String id);

  OrderDto getOrderDto(String id);

  List<Order> getOrderList(OrderStatus orderStatus, Integer pageNumber, Integer pageSize);

  List<OrderDto> getOrderDtoList(OrderStatus orderStatus, Integer pageNumber, Integer pageSize);

  Order createOrder(OrderDto orderDto);

  void updateOrder(String id, OrderDto orderDto);

  void deleteOrder(String id);

  void updateOrderStatus(String id, OrderStatus orderStatus);
}
