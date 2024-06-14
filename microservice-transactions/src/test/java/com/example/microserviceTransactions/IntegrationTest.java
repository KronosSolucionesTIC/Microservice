package com.example.microserviceTransactions;

import com.example.microserviceTransactions.infrastructure.persistence.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IntegrationTest {

    private final AccountRepository accountRepository;
    private final MockMvc mockMvc;

    @Autowired
    public IntegrationTest(AccountRepository accountRepository, MockMvc mockMvc) {
        this.accountRepository = accountRepository;
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    public void setup() {
        accountRepository.deleteAll();
    }

    @Test
    public void findAllAccountTest() throws Exception {
        mockMvc.perform(get("/api/cuentas/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void createAccountTest() throws Exception {
        String accountJson = "{ \"accountNumber\": \"42134\", \"accountType\": \"Ahorro\", \"customerId\":1, \"status\":\"True\"}";

        mockMvc.perform(post("/api/cuentas/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"accountNumber\":\"42134\",\"accountType\":\"Ahorro\", \"customerId\":1, \"status\":\"True\"}"));
    }
}

