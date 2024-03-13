package com.innowise.customerservice.service;

import com.innowise.customerservice.dto.CustomerDto;
import com.innowise.customerservice.model.Customer;

public interface CustomerService {

  CustomerDto getCustomer(Long id);

  Customer createCustomer(CustomerDto customerDto);

  void updateCustomer(Long id, CustomerDto customerDto);

  void deleteCustomer(Long id);

  boolean existsById(Long id);

  default boolean notExistsById(Long id) {
    return !existsById(id);
  }
}
