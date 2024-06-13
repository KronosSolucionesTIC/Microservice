package com.example.microservicePersons.infrastructure.persistence.repository;

import com.example.microservicePersons.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
