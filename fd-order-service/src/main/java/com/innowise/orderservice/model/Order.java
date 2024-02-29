package com.innowise.orderservice.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Getter
@Setter
public class Order {

  @Id
  private String id;
  
  private List<OrderProduct> orderProductList;
  
  private OrderStatus orderStatus;
}
