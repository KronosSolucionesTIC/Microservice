package com.example.microserviceTransactions.interfaces.rest;

import com.example.microserviceTransactions.application.service.AccountService;
import com.example.microserviceTransactions.interfaces.dto.AccountDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllAccounts() {
        try {
            List<AccountDTO> accounts = accountService.findAll();
            return ResponseEntity.ok(accounts);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting accounts: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable Long id) {
        try {
            AccountDTO accountDTO = accountService.findById(id);
            return ResponseEntity.ok(accountDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting account: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createAccount(@RequestBody @Valid AccountDTO accountDTO) {
        try {
            AccountDTO account = accountService.createAccount(accountDTO);
            return ResponseEntity.ok(account);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating account: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable Long id, @Valid @RequestBody AccountDTO accountDTO) {
        try {
            AccountDTO updatedAccount = accountService.updateAccount(id, accountDTO);
            return ResponseEntity.ok(updatedAccount);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating account: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id) {
        try {
            accountService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting account: " + e.getMessage());
        }
    }
}