package com.innowise.customerservice.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import com.innowise.customerservice.dto.OrderDto;
import com.innowise.customerservice.model.OrderStatus;
import com.innowise.customerservice.service.OrderService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize) {
    List<OrderDto> orderDtoList = orderService.getOrderList(
        customerId, orderStatus, pageNumber, pageSize);
    return ok(orderDtoList);
  }

  @PostMapping
  public ResponseEntity<Void> createOrder(
      @PathVariable Long customerId,
      @RequestBody OrderDto orderDto) {
    orderService.createOrder(customerId, orderDto);
    String location = "/orders";
    return created(URI.create(location)).build();
  }
}
