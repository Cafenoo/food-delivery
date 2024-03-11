package com.innowise.restaurantservice.service;

import com.innowise.restaurantservice.dto.OrderDto;
import com.innowise.restaurantservice.model.OrderStatus;
import java.util.List;

public interface OrderService {

  List<OrderDto> getOrderList(
      Long restaurantId,
      OrderStatus orderStatus,
      Integer pageNumber,
      Integer pageSize);
}
