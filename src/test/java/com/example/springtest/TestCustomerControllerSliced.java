package com.example.springtest;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springtest.controllers.CustomerController;
import com.example.springtest.domain.CustomerDTO;
import com.example.springtest.services.CustomerService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(CustomerController.class)
public class TestCustomerControllerSliced {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    public void testGettingAllCustomers() throws Exception {
        when(service.getAllCustomers()).thenReturn(
                List.of(CustomerDTO
                        .builder()
                        .id(1L)
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

    @Test
    public void shouldCreateSuccessfullyTheCustomer() throws Exception {
        when(service.createCustomer(any())).thenReturn(
            CustomerDTO
                .builder()
                .id(2L)
                .username("john")
                .firstName("John")
                .lastName("Doe")
                .build()
        );

        String body = "{\"username\": \"username1\", "
            + "\"firstName\": \"firstName1\", "
            + "\"lastName\": \"lastName1\"}";

        MvcResult result = this.mockMvc.perform(post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
            .andDo(print())
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test
    public void shouldFetchCustomerById() throws Exception {
        when(service.getCustomer(any())).thenReturn(
            CustomerDTO
                .builder()
                .id(3L)
                .username("john")
                .firstName("John")
                .lastName("Doe")
                .build()
        );

        MvcResult result = this.mockMvc.perform(get("/customer/1")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

}
