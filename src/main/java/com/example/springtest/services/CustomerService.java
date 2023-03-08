package com.example.springtest.services;

import com.example.springtest.domain.Customer;
import com.example.springtest.domain.CustomerDTO;
import com.example.springtest.repository.CustomerRepository;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository repository;

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        List<CustomerDTO> response = toCustomerDtoList(customers);
        return response;
    }

    private List<CustomerDTO> toCustomerDtoList(List<Customer> customers) {
        return new ArrayList<>();
    }

    public CustomerDTO createCustomer(Customer customer) {
        return null;
    }

    public CustomerDTO getCustomer(String id) {
        return null;
    }
}
