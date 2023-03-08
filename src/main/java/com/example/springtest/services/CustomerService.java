package com.example.springtest.services;

import com.example.springtest.domain.Customer;
import com.example.springtest.domain.CustomerDTO;
import com.example.springtest.mapper.CustomerMapper;
import com.example.springtest.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository repository;

    private CustomerMapper customerMapper;

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        List<CustomerDTO> response = customerMapper.toCustomerDtoList(customers);
        return response;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.mapToCustomer(customerDTO);
        Customer saved = repository.save(customer);
        CustomerDTO response = customerMapper.mapToCustomerDTO(saved);
        return response;
    }

    public CustomerDTO getCustomer(Long id) {
        Optional<Customer> customer = repository.findById(id);
        CustomerDTO response = customerMapper.mapToCustomerDTO(customer.get());
        return response;
    }
}
