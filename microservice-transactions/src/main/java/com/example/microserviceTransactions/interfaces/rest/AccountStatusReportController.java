package com.example.microserviceTransactions.interfaces.rest;

import com.example.microserviceTransactions.application.service.AccountStatusReportService;
import com.example.microserviceTransactions.interfaces.dto.AccountStatusReportDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class AccountStatusReportController {
    private AccountStatusReportService accountStatusReportService;

    public AccountStatusReportController(AccountStatusReportService accountStatusReportService) {
        this.accountStatusReportService = accountStatusReportService;
    }

    @GetMapping
    public ResponseEntity<List<AccountStatusReportDTO>> getReport(
            @RequestParam Long customerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<AccountStatusReportDTO> report = accountStatusReportService.generateReport(customerId, startDate, endDate);
        return ResponseEntity.ok(report);
    }
}






