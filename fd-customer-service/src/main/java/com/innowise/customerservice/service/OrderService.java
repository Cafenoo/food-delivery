package com.innowise.customerservice.service;

import com.innowise.customerservice.dto.OrderDto;
import com.innowise.customerservice.model.OrderStatus;
import java.util.List;

public interface OrderService {

  List<OrderDto> getOrderList(
      Long customerId,
      OrderStatus orderStatus,
      Integer pageNumber,
      Integer pageSize);

  void createOrder(Long customerId, OrderDto orderDto);
}
