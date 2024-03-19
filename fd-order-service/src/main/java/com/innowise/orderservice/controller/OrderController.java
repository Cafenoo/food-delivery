package com.innowise.orderservice.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.repository.OrderCustomRepositoryImpl.SelectedId;
import com.innowise.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
  @PageableAsQueryParam
  public ResponseEntity<Page<OrderDto>> getOrderList(
      @RequestParam(required = false) OrderStatus orderStatus,
      @RequestParam(required = false) SelectedId selectedId,
      @RequestParam(required = false) Long id,
      @PageableDefault(sort = "id") Pageable pageable) {
    Page<OrderDto> orderDtoList = orderService.getOrderList(
        orderStatus, pageable, selectedId, id);
    return ok(orderDtoList);
  }

  @PostMapping
  public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
    Order order = orderService.createOrder(orderDto);
    return status(CREATED.value()).body(order);
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
