package com.example.microserviceTransactions.domain.exceptions;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(Long id) {
        super("Movement not found with id " + id);
    }
}
