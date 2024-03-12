package com.innowise.orderservice.repository;

import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

  Page<Order> findAllByOrderStatus(OrderStatus orderStatus, Pageable pageable);

  Page<Order> findAllByCustomerIdAndOrderStatus(
      Long customerId, OrderStatus orderStatus, Pageable pageable);

  Page<Order> findAllByRestaurantIdAndOrderStatus(
      Long customerId, OrderStatus orderStatus, Pageable pageable);

  Page<Order> findAllByDeliveryManIdAndOrderStatus(
      Long customerId, OrderStatus orderStatus, Pageable pageable);
}
