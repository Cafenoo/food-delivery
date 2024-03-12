package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

  OrderDto getOrder(String id);

  Page<OrderDto> getOrderList(OrderStatus orderStatus, Pageable pageable);

  Page<OrderDto> getOrderListByCustomerId(
      Long customerId, OrderStatus orderStatus, Pageable pageable);

  Page<OrderDto> getOrderListByRestaurantId(
      Long restaurantId, OrderStatus orderStatus, Pageable pageable);

  Page<OrderDto> getOrderListByDeliveryManId(
      Long deliveryManId, OrderStatus orderStatus, Pageable pageable);

  Order createOrder(OrderDto orderDto);

  void updateOrder(String id, OrderDto orderDto);

  void deleteOrder(String id);

  void updateOrderStatus(String id, OrderStatus orderStatus);
}
