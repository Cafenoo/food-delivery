package com.innowise.restaurantservice.model;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column
  private String title;

  @Column
  private BigDecimal price;

  @ManyToOne(fetch = LAZY)
  private Restaurant restaurant;
}
