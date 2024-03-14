package com.innowise.orderservice.repository;

import static java.util.Objects.nonNull;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.innowise.orderservice.model.Order;
import com.innowise.orderservice.model.OrderStatus;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {

  private final MongoTemplate mongoTemplate;

  @Override
  public Page<Order> findAllByOrderStatus(
      OrderStatus orderStatus, Pageable pageable, SelectedId selectedId, String id) {
    Query query = new Query();

    if (nonNull(selectedId)) {
      query.addCriteria(where(selectedId.getSelector()).is(id));
    }

    if (nonNull(orderStatus)) {
      query.addCriteria(where("orderStatus").is(orderStatus));
    }

    query.with(pageable);

    List<Order> orders = mongoTemplate.find(query, Order.class);

    long count = mongoTemplate.count(query, Order.class);

    return new PageImpl<>(orders, pageable, count);
  }

  @RequiredArgsConstructor
  @Getter
  public enum SelectedId {
    CUSTOMER("customerId"),
    RESTAURANT("restaurantId"),
    DELIVERY_MAN("deliveryManId");

    private final String selector;
  }
}
