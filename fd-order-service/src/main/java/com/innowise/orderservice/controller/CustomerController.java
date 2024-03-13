package com.innowise.orderservice.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.repository.OrderCustomRepositoryImpl.SelectedId;
import com.innowise.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
  @PageableAsQueryParam
  public ResponseEntity<Page<OrderDto>> getOrderList(
      @PathVariable String customerId,
      @RequestParam(required = false) OrderStatus orderStatus,
      @PageableDefault(sort = "id") Pageable pageable) {
    Page<OrderDto> orderList = orderService.getOrderListBySelectedId(
        orderStatus, pageable, SelectedId.CUSTOMER, customerId);
    return ok(orderList);
  }
}
