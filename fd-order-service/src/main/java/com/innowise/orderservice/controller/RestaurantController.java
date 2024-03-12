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
@RequestMapping("/api/orders/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
  private final OrderService orderService;

  @GetMapping("/{restaurantId}")
  public ResponseEntity<Page<OrderDto>> getOrderList(
      @PathVariable Long restaurantId,
      @RequestParam(required = false) OrderStatus orderStatus,
      @RequestParam Pageable pageable) {
    Page<OrderDto> orderList = orderService.getOrderListByRestaurantId(
        restaurantId, orderStatus, pageable);
    return ResponseEntity.ok(orderList);
  }
}
