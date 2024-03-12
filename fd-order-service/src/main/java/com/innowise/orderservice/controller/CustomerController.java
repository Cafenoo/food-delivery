package com.innowise.orderservice.controller;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final OrderService orderService;

  @GetMapping("/{customerId}")
  public ResponseEntity<Page<OrderDto>> getOrderList(
      @PathVariable Long customerId,
      @RequestParam(required = false) OrderStatus orderStatus,
      @RequestParam Pageable pageable) {
    Page<OrderDto> orderList = orderService.getOrderListByCustomerId(
        customerId, orderStatus, pageable);
    return ResponseEntity.ok(orderList);
  }
}
