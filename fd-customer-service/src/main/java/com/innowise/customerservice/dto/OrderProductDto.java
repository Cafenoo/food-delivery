package com.innowise.customerservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderProductDto {

  private Long productId;
  
  private Integer count;
}
