package com.innowise.customerservice.service.impl;

import com.innowise.customerservice.dto.OrderDto;
import com.innowise.customerservice.model.OrderStatus;
import com.innowise.customerservice.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  @Override
  public List<OrderDto> getOrderDtoList(
      Long customerId,
      OrderStatus orderStatus,
      Integer pageNumber,
      Integer pageSize) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void createOrder(Long customerId, OrderDto orderDto) {
    throw new UnsupportedOperationException();
  }
}
