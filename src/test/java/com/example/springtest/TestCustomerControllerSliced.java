package com.example.springtest;


import com.example.springtest.controllers.CustomerController;
import com.example.springtest.domain.Customer;
import com.example.springtest.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class TestCustomerControllerSliced {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    public void testGettingAllCustomers() throws Exception {
        when(service.getAllCustomers()).thenReturn(
                List.of(Customer
                        .builder()
                        .username("john")
                        .firstName("John")
                        .lastName("Doe")
                        .build())
        );

        MvcResult result = this.mockMvc.perform(get("/customer"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
