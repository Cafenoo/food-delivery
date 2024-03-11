package com.innowise.restaurantservice.controller;

import com.innowise.restaurantservice.dto.OrderDto;
import com.innowise.restaurantservice.model.OrderStatus;
import com.innowise.restaurantservice.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public ResponseEntity<List<OrderDto>> getRestaurantOrders(
      @PathVariable Long restaurantId,
      @RequestParam(required = false) OrderStatus orderStatus,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize) {
    List<OrderDto> orderList = orderService.getOrderList(
        restaurantId, orderStatus, pageNumber, pageSize);
    return ResponseEntity.ok(orderList);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateOrderStatus(
      @PathVariable Long restaurantId,
      @PathVariable Long id) {
    throw new UnsupportedOperationException();
  }
}
