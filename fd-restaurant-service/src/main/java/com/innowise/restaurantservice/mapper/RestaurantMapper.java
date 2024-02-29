package com.innowise.restaurantservice.mapper;

import com.innowise.restaurantservice.dto.RestaurantDto;
import com.innowise.restaurantservice.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

  @Mapping(target = "id", ignore = true)
  Restaurant toEntity(RestaurantDto restaurantDto);

  RestaurantDto toDto(Restaurant restaurant);
}
