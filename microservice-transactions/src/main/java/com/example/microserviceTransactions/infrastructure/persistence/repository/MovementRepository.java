package com.example.microserviceTransactions.infrastructure.persistence.repository;

import com.example.microserviceTransactions.domain.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    List<Movement> findByAccountIdAndDateBetween(Long accountId, LocalDate startDate, LocalDate endDate);
}
