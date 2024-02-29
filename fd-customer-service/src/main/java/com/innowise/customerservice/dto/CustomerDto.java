package com.innowise.customerservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDto {

  private String name;

  private String address;
}
