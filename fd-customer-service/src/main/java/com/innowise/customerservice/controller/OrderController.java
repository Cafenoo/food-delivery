package com.innowise.customerservice.controller;

import com.innowise.customerservice.dto.OrderDto;
import com.innowise.customerservice.model.OrderStatus;
import com.innowise.customerservice.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers/{customerId}/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public ResponseEntity<List<OrderDto>> getOrderList(
      @PathVariable Long customerId,
      @RequestParam(required = false) OrderStatus orderStatus,
      @RequestParam Pageable pageable) {
    throw new UnsupportedOperationException();
  }

  @PostMapping
  public ResponseEntity<Void> createOrder(
      @PathVariable Long customerId,
      @RequestBody OrderDto orderDto) {
    throw new UnsupportedOperationException();
  }
}
