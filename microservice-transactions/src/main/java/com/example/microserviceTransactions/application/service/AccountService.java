package com.example.microserviceTransactions.application.service;

import com.example.microserviceTransactions.application.mapper.AccountMapper;
import com.example.microserviceTransactions.domain.exceptions.AccountNotFoundException;
import com.example.microserviceTransactions.domain.exceptions.CustomerNotFoundException;
import com.example.microserviceTransactions.domain.model.Account;
import com.example.microserviceTransactions.infrastructure.integration.CustomerClient;
import com.example.microserviceTransactions.infrastructure.persistence.repository.AccountRepository;
import com.example.microserviceTransactions.interfaces.dto.AccountDTO;
import com.example.microserviceTransactions.interfaces.dto.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private CustomerClient customerClient;
    private AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, CustomerClient customerClient, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
        this.accountMapper = accountMapper;
    }

    @Transactional
    public AccountDTO createAccount(AccountDTO accountDTO) {
        CustomerDTO customer = customerClient.getCustomerById(accountDTO.getCustomerId());
        if (customer == null) {
            throw new CustomerNotFoundException(accountDTO.getCustomerId());
        }

        Account account = accountMapper.accountDTOToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.accountToAccountDTO(savedAccount);
    }

    @Transactional
    public AccountDTO updateAccount(Long id, AccountDTO accountDTO) {
        Account account = accountRepository.findById(id)
                    .orElseThrow(() -> new AccountNotFoundException(id));

        CustomerDTO customer = customerClient.getCustomerById(accountDTO.getCustomerId());
        if (customer == null) {
            throw new CustomerNotFoundException(accountDTO.getCustomerId());
        }

        accountMapper.updateAccountFromDTO(accountDTO, account);
        Account updatedAccount = accountRepository.save(account);
        return accountMapper.accountToAccountDTO(updatedAccount);
    }

    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.accountListToAccountDTOList(accounts);
    }

    public AccountDTO findById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        return accountMapper.accountToAccountDTO(account);
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
