package com.innowise.deliveryservice.controller;

import com.innowise.deliveryservice.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries/{deliveryManId}/orders")
@RequiredArgsConstructor
public class OrderController {

  @GetMapping
  public ResponseEntity<Void> getReadyOrders(@PathVariable Long deliveryManId) {
    throw new UnsupportedOperationException();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateOrderStatus(
      @PathVariable Long deliveryManId,
      @PathVariable Long id,
      @RequestParam OrderStatus orderStatus) {
    throw new UnsupportedOperationException();
  }
}
