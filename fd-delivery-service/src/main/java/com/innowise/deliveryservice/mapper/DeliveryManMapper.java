package com.innowise.deliveryservice.mapper;

import com.innowise.deliveryservice.dto.DeliveryManDto;
import com.innowise.deliveryservice.model.DeliveryMan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryManMapper {

  @Mapping(target = "id", ignore = true)
  DeliveryMan toEntity(DeliveryManDto productDto);

  DeliveryManDto toDto(DeliveryMan product);
}
