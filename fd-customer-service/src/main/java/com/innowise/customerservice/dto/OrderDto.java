package com.innowise.customerservice.dto;

import com.innowise.customerservice.model.OrderStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

  private List<OrderProductDto> orderProductDtoList;

  private OrderStatus orderStatus;
}
