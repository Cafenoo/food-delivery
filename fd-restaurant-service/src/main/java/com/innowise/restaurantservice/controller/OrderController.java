package com.innowise.restaurantservice.controller;

import com.innowise.restaurantservice.model.OrderStatus;
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

  @GetMapping
  public ResponseEntity<Void> getRestaurantOrders(
      @PathVariable Long restaurantId,
      @RequestParam(required = false) OrderStatus orderStatus) {
    throw new UnsupportedOperationException();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateOrderStatus(
      @PathVariable Long restaurantId,
      @PathVariable Long id) {
    throw new UnsupportedOperationException();
  }
}
