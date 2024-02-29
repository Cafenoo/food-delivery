package com.innowise.restaurantservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RestaurantDto {

  private String title;

  private String address;
}
