package com.innowise.customerservice.dto;

import com.innowise.customerservice.model.OrderStatus;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderDto {

  private List<OrderProductDto> orderProductDtoList;

  private OrderStatus orderStatus;
}
