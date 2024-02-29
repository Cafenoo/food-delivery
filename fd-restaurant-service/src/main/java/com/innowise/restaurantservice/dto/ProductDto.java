package com.innowise.restaurantservice.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {

  private String title;

  private BigDecimal price;
}
