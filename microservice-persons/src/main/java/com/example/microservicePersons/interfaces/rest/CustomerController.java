package com.example.microservicePersons.interfaces.rest;

import com.example.microservicePersons.application.service.CustomerService;
import com.example.microservicePersons.domain.model.Customer;
import com.example.microservicePersons.interfaces.dto.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllCustomers() {
        try {
            List<CustomerDTO> customersDTO = customerService.findAll();
            return ResponseEntity.ok(customersDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting customers: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long id) {
        try {
            CustomerDTO customerDTO = customerService.findById(id);
            return ResponseEntity.ok(customerDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting customer: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        try {
            CustomerDTO customerDTOResponse = customerService.createCustomer(customerDTO);
            return ResponseEntity.ok(customerDTOResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating customer: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDTO) {
        try {
            CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
            return ResponseEntity.ok(updatedCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating customer: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting customer: " + e.getMessage());
        }
    }
}


