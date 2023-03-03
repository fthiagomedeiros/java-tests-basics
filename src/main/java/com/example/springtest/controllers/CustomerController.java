package com.example.springtest.controllers;

import com.example.springtest.domain.Customer;
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
    @RolesAllowed("ADMIN")
    public ResponseEntity<List<Customer>> fetchAllCustomers() {
        List<Customer> customers = service.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping
    @RolesAllowed("SUPER_ADMIN")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer,
        UriComponentsBuilder uriComponentsBuilder) {
        Customer customers = service.createCustomer(customer);
        return ResponseEntity.created(uriComponentsBuilder.path("/customer/{taskId}")
            .build(customers.getId())).build();
    }

    @GetMapping({"{id}"})
    @RolesAllowed("ADMIN")
    public ResponseEntity<Customer> fetchCustomerById(@PathVariable String id) {
        Customer customer = service.getCustomer(id);
        return ResponseEntity.ok().body(customer);
    }

}
