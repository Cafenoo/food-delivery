package com.innowise.orderservice.repository;

import com.innowise.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String>, OrderCustomRepository {}
