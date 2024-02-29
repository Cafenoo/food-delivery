package com.innowise.customerservice.service;

import com.innowise.customerservice.dto.CustomerDto;
import com.innowise.customerservice.model.Customer;

public interface CustomerService {

  Customer getCustomer(Long id);

  CustomerDto getCustomerDto(Long id);

  Customer createCustomer(CustomerDto customerDto);

  void updateCustomer(Long id, CustomerDto customerDto);

  void deleteCustomer(Long id);
}
