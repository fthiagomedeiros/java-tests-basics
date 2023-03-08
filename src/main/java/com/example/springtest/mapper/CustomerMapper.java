package com.example.springtest.mapper;

import com.example.springtest.domain.Customer;
import com.example.springtest.domain.CustomerDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO mapToCustomerDTO(Customer customer);

    Customer mapToCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> toCustomerDtoList(List<Customer> customers);
}