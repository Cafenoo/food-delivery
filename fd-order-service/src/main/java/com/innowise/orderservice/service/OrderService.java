package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.repository.OrderCustomRepositoryImpl.SelectedId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

  OrderDto getOrder(String id);

  Page<OrderDto> getOrderList(OrderStatus orderStatus, Pageable pageable);

  Page<OrderDto> getOrderListBySelectedId(
      OrderStatus orderStatus,
      Pageable pageable,
      SelectedId selectedId,
      String id);

  Order createOrder(OrderDto orderDto);

  void updateOrder(String id, OrderDto orderDto);

  void deleteOrder(String id);

  void updateOrderStatus(String id, OrderStatus orderStatus);
}
