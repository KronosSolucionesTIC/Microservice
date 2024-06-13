package com.example.microservicePersons.application.mapper;

import com.example.microservicePersons.domain.model.Customer;
import com.example.microservicePersons.interfaces.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> customerListToCustomerDTOList(List<Customer> customersList);

    List<Customer> customerDTOListToCustomerList(List<CustomerDTO> customersDTOList);

    @Mapping(target = "id", ignore = true)
    void updateCustomerFromDTO(CustomerDTO customerDTO, @MappingTarget Customer customer);
}
