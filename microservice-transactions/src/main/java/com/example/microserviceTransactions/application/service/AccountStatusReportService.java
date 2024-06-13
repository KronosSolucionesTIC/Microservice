package com.example.microserviceTransactions.application.service;

import com.example.microserviceTransactions.domain.model.Account;
import com.example.microserviceTransactions.domain.model.Movement;
import com.example.microserviceTransactions.infrastructure.persistence.repository.AccountRepository;
import com.example.microserviceTransactions.infrastructure.persistence.repository.MovementRepository;
import com.example.microserviceTransactions.interfaces.dto.AccountStatusReportDTO;
import com.example.microserviceTransactions.interfaces.dto.MovementDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountStatusReportService {

    private final AccountRepository accountRepository;
    private final MovementRepository movementRepository;

    public AccountStatusReportService(AccountRepository accountRepository, MovementRepository movementRepository) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
    }

    public List<AccountStatusReportDTO> generateReport(Long customerId, LocalDate startDate, LocalDate endDate) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        List<AccountStatusReportDTO> report = new ArrayList<>();

        for (Account account : accounts) {
            AccountStatusReportDTO accountStatusReportDTO = new AccountStatusReportDTO();
            accountStatusReportDTO.setAccountId(account.getId());
            accountStatusReportDTO.setAccountNumber(account.getAccountNumber());
            accountStatusReportDTO.setBalance(account.getBalance());

            List<Movement> movements = movementRepository.findByAccountIdAndDateBetween(account.getId(), startDate, endDate);
            List<MovementDTO> movementDTOs = movements.stream().map(movement -> {
                MovementDTO movementDTO = new MovementDTO();
                movementDTO.setId(movement.getId());
                movementDTO.setMovementType(movement.getMovementType());
                movementDTO.setDate(movement.getDate());
                movementDTO.setInitialBalance(movement.getInitialBalance());
                movementDTO.setAmount(movement.getAmount());
                movementDTO.setAvailableBalance(movement.getAvailableBalance());
                movementDTO.setAccountId(movement.getAccount().getId());
                return movementDTO;
            }).collect(Collectors.toList());

            accountStatusReportDTO.setMovements(movementDTOs);
            report.add(accountStatusReportDTO);
        }

        return report;
    }
}

