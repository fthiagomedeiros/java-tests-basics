package com.example.springtest.controllers;

import com.example.springtest.domain.Customer;
import com.example.springtest.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> fetchAllCustomers() {
        List<Customer> customers = service.getAllCustomers();
        return new ResponseEntity<>(customers, OK);
    }

}
