package com.innowise.orderservice.repository;

import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import com.innowise.orderservice.repository.OrderCustomRepositoryImpl.SelectedId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderCustomRepository {

  Page<Order> findAll(
      OrderStatus orderStatus,
      Pageable pageable,
      SelectedId selectedId,
      Long id);
}
