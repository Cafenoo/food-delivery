package com.innowise.customerservice.service.impl;

import com.innowise.customerservice.dto.CustomerDto;
import com.innowise.customerservice.mapper.CustomerMapper;
import com.innowise.customerservice.model.Customer;
import com.innowise.customerservice.repository.CustomerRepository;
import com.innowise.customerservice.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Override
  @Transactional(readOnly = true)
  public CustomerDto getCustomer(Long id) {
    Customer customer = customerRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);
    return customerMapper.toDto(customer);
  }

  @Override
  @Transactional
  public Customer createCustomer(CustomerDto customerDto) {
    Customer customer = customerMapper.toEntity(customerDto);
    return customerRepository.save(customer);
  }

  @Override
  @Transactional
  public void updateCustomer(Long id, CustomerDto customerDto) {
    if (!existsById(id)) {
      throw new EntityNotFoundException();
    }

    Customer convertedCustomer = customerMapper.toEntity(customerDto);
    convertedCustomer.setId(id);

    customerRepository.save(convertedCustomer);
  }

  @Override
  @Transactional
  public void deleteCustomer(Long id) {
    if (!existsById(id)) {
      throw new EntityNotFoundException();
    }

    customerRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return customerRepository.findById(id)
        .isPresent();
  }
}
