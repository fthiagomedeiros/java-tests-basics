package com.example.springtest.services;

import com.example.springtest.domain.Customer;
import com.example.springtest.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        return customers;
    }

    public Customer createCustomer(Customer customer) {
        return null;
    }
}
