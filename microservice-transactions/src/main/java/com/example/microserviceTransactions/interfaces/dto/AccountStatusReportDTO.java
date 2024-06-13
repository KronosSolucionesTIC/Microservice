package com.example.microserviceTransactions.interfaces.dto;

import java.util.List;

public class AccountStatusReportDTO {
     private Long accountId;
     private String accountNumber;
     private double balance;
     private List<MovementDTO> movements;

    public AccountStatusReportDTO() {
    }

    public AccountStatusReportDTO(Long accountId, String accountNumber, double balance, List<MovementDTO> movements) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.movements = movements;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<MovementDTO> getMovements() {
        return movements;
    }

    public void setMovements(List<MovementDTO> movements) {
        this.movements = movements;
    }
}
