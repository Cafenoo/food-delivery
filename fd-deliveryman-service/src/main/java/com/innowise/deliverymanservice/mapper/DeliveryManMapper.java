package com.innowise.deliverymanservice.mapper;

import com.innowise.deliverymanservice.dto.DeliveryManDto;
import com.innowise.deliverymanservice.model.DeliveryMan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryManMapper {

  @Mapping(target = "id", ignore = true)
  DeliveryMan toEntity(DeliveryManDto productDto);

  DeliveryManDto toDto(DeliveryMan product);
}
