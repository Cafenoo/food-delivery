package com.innowise.orderservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderProduct {

  private Long productId;

  private Integer count;
}
