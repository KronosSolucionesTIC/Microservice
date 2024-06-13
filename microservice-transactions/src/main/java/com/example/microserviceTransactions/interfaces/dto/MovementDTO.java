package com.example.microserviceTransactions.interfaces.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MovementDTO {
    private Long id;
    @Column(name="account_id")
    @NotNull(message = "The accountId is mandatory")
    private Long accountId;

    @NotNull(message = "The movementType is mandatory")
    @NotEmpty(message = "The movementType is mandatory")
    private String movementType;
    @NotNull(message = "The date is mandatory")
    private LocalDate date;
    private double initialBalance;

    @NotNull(message = "The amount is mandatory")
    private double amount;
    private double availableBalance;
    public MovementDTO() {
    }

    public MovementDTO(Long id, Long accountId, String movementType, LocalDate date, double initialBalance, double amount, double availableBalance) {
        this.id = id;
        this.accountId = accountId;
        this.movementType = movementType;
        this.date = date;
        this.initialBalance = initialBalance;
        this.amount = amount;
        this.availableBalance = availableBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
}
