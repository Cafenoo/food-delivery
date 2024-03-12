package com.innowise.customerservice.controller;

import static java.text.MessageFormat.format;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.innowise.customerservice.dto.CustomerDto;
import com.innowise.customerservice.model.Customer;
import com.innowise.customerservice.service.CustomerService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("/{id}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
    CustomerDto customerDto = customerService.getCustomer(id);
    return ok(customerDto);
  }

  @PostMapping
  public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto) {
    Customer customer = customerService.createCustomer(customerDto);
    String location = format("/customer/{0}", customer.getId());
    return created(URI.create(location)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateCustomer(
      @PathVariable Long id,
      @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(id, customerDto);
    return noContent().build();
  }

  @DeleteMapping("/{id}")
  private ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return noContent().build();
  }
}
