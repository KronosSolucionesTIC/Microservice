package com.example.microservicePersons.application.service;

import com.example.microservicePersons.application.mapper.CustomerMapper;
import com.example.microservicePersons.domain.exceptions.CustomerNotFoundException;
import com.example.microservicePersons.domain.model.Customer;
import com.example.microservicePersons.infrastructure.persistence.repository.CustomerRepository;
import com.example.microservicePersons.interfaces.dto.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.customerListToCustomerDTOList(customers);
    }

    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.customerToCustomerDTO(customer);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customerMapper.updateCustomerFromDTO(customerDTO, customer);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(updatedCustomer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}