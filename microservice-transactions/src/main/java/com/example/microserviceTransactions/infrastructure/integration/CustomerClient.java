package com.example.microserviceTransactions.infrastructure.integration;

import com.example.microserviceTransactions.interfaces.dto.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "customer-service", url = "http://localhost:8081")
public interface CustomerClient {
    @GetMapping("/api/clientes/get/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long id);
}
