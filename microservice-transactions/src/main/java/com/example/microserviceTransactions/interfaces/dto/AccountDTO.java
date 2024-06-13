package com.example.microserviceTransactions.interfaces.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AccountDTO {
    private Long id;
    @NotNull(message = "The accountNumber is mandatory")
    @NotEmpty(message = "The accountNumber is mandatory")
    private String accountNumber;

    private String accountType;
    private double balance;
    @NotNull(message = "The status is mandatory")
    @NotEmpty(message = "The status is mandatory")
    private String status;
    @NotNull(message = "The customerId is mandatory")
    private Long customerId;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String accountNumber, String accountType, double balance, String status, Long customerId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
