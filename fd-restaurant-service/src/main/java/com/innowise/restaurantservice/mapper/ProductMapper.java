package com.innowise.restaurantservice.mapper;

import com.innowise.restaurantservice.dto.ProductDto;
import com.innowise.restaurantservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "restaurant", ignore = true)
  Product toEntity(ProductDto productDto);

  ProductDto toDto(Product product);
}
