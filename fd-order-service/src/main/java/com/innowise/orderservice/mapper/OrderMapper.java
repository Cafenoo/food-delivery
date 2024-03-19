package com.innowise.orderservice.mapper;

import com.innowise.orderservice.dto.OrderDto;
import com.innowise.orderservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "orderStatus", ignore = true)
  Order toEntity(OrderDto customerDto);

  OrderDto toDto(Order customer);
}
