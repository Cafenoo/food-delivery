package com.innowise.orderservice.dto;

import com.innowise.orderservice.model.OrderProduct;
import java.util.List;
import com.innowise.orderservice.model.OrderStatus;
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

  private OrderStatus orderStatus;
}
