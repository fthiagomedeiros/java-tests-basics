package com.example.springtest.controllers;

import com.example.springtest.domain.Customer;
import com.example.springtest.domain.CustomerDTO;
import com.example.springtest.services.CustomerService;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> fetchAllCustomers() {
        List<CustomerDTO> customers = service.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO mCustomer,
        UriComponentsBuilder uriComponentsBuilder) {
        CustomerDTO customer = service.createCustomer(mCustomer);
        return ResponseEntity.created(uriComponentsBuilder.path("/customer/{customerId}")
            .build(customer.getId())).build();
    }

    @GetMapping({"{id}"})
    public ResponseEntity<CustomerDTO> fetchCustomerById(@PathVariable Long id) {
        CustomerDTO customer = service.getCustomer(id);
        return ResponseEntity.ok().body(customer);
    }

}
