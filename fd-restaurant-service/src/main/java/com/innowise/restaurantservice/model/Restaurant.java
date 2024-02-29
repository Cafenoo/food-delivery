package com.innowise.restaurantservice.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column
  private String title;

  @Column
  private String address;
}
