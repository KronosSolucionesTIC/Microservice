package com.example.microserviceTransactions.domain.exceptions;

public class BalanceNotAvailableException extends RuntimeException {
    public BalanceNotAvailableException(String message) {
        super(message);
    }
}