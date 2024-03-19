package com.innowise.orderservice.dto;

import com.innowise.orderservice.model.OrderProduct;
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

  private List<OrderProduct> orderProductList;
}
