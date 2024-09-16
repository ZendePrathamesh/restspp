package com.fq.restspp.service;

import com.fq.restspp.enitity.Customer;
import com.fq.restspp.exception.ResourceNotFoundException;
import com.fq.restspp.repository.CustomerRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer getCustomerById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public Customer updateCustomer(Long id, Customer updatedCustomer) {
    Customer existingCustomer = getCustomerById(id);
    existingCustomer.setName(updatedCustomer.getName());
    existingCustomer.setEmail(updatedCustomer.getEmail());
    return customerRepository.save(existingCustomer);
  }

  public void deleteCustomer(Long id) {
    Customer customer = getCustomerById(id);
    customerRepository.delete(customer);
  }
}
