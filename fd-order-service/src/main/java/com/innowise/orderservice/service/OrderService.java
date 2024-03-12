package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import org.springframework.data.domain.Page;

public interface OrderService {

  OrderDto getOrder(String id);

  Page<OrderDto> getOrderList(OrderStatus orderStatus, Integer pageNumber, Integer pageSize);

  Order createOrder(OrderDto orderDto);

  void updateOrder(String id, OrderDto orderDto);

  void deleteOrder(String id);

  void updateOrderStatus(String id, OrderStatus orderStatus);
}
