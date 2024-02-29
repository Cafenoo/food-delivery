package com.innowise.customerservice.mapper;

import com.innowise.customerservice.dto.CustomerDto;
import com.innowise.customerservice.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mapping(target = "id", ignore = true)
  Customer toEntity(CustomerDto customerDto);

  CustomerDto toDto(Customer customer);
}
