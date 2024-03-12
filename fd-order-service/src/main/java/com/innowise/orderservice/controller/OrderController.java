package com.innowise.orderservice.controller;

import static java.text.MessageFormat.format;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.created;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.service.OrderService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/{id}")
  public ResponseEntity<OrderDto> getOrder(@PathVariable String id) {
    OrderDto orderDto = orderService.getOrder(id);
    return ok(orderDto);
  }

  @GetMapping
  public ResponseEntity<Page<OrderDto>> getOrderList(
      @RequestParam(required = false) OrderStatus orderStatus,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize) {
    Page<OrderDto> orderDtoList = orderService.getOrderList(orderStatus, pageNumber, pageSize);
    return ok(orderDtoList);
  }

  @PostMapping
  public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
    Order order = orderService.createOrder(orderDto);
    String location = format("/orders/{0}", order.getId());
    return created(URI.create(location)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateOrder(
      @PathVariable String id,
      @RequestBody OrderDto orderDto) {
    orderService.updateOrder(id, orderDto);
    return noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
    orderService.deleteOrder(id);
    return noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateOrderStatus(
      @PathVariable String id,
      @RequestParam OrderStatus orderStatus) {
    orderService.updateOrderStatus(id, orderStatus);
    return noContent().build();
  }
}
