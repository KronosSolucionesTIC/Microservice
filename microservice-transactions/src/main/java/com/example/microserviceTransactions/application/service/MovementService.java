package com.example.microserviceTransactions.application.service;

import com.example.microserviceTransactions.application.mapper.MovementMapper;
import com.example.microserviceTransactions.domain.exceptions.AccountNotFoundException;
import com.example.microserviceTransactions.domain.exceptions.BalanceNotAvailableException;
import com.example.microserviceTransactions.domain.exceptions.MovementNotFoundException;
import com.example.microserviceTransactions.domain.model.Account;
import com.example.microserviceTransactions.domain.model.Movement;
import com.example.microserviceTransactions.infrastructure.persistence.repository.AccountRepository;
import com.example.microserviceTransactions.infrastructure.persistence.repository.MovementRepository;
import com.example.microserviceTransactions.interfaces.dto.MovementDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovementService {

    private MovementRepository movementRepository;

    private AccountRepository accountRepository;


    private MovementMapper movementMapper;

    public MovementService(MovementRepository movementRepository, AccountRepository accountRepository, MovementMapper movementMapper) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
        this.movementMapper = movementMapper;
    }

    @Transactional
    public MovementDTO createMovement(MovementDTO movementDTO) {
        Account account = accountRepository.findById(movementDTO.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException(movementDTO.getAccountId()));

        validateBalanceAvailable(movementDTO, account);

        Movement movement = movementMapper.movementDTOToMovement(movementDTO);
        movement.setInitialBalance(account.getBalance());
        movement.setAvailableBalance(account.getBalance() + movementDTO.getAmount());
        movement.setAccount(account);
        Movement savedMovement = movementRepository.save(movement);
        updateBalance(movementDTO, savedMovement);
        return movementMapper.movementToMovementDTO(savedMovement);
    }

    @Transactional
    public void updateBalance(MovementDTO movementDTO, Movement movement) {
        Account account = accountRepository.findById(movementDTO.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException(movementDTO.getAccountId()));

        account.setBalance(account.getBalance() + movementDTO.getAmount());
        account.getMovements().add(movement);
    }

    @Transactional
    public MovementDTO updateMovement(Long id, MovementDTO movementDTO) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new MovementNotFoundException(id));

        Account account = accountRepository.findById(movementDTO.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException(movementDTO.getAccountId()));

        movementMapper.updateMovementFromDTO(movementDTO, movement);
        Movement updatedMovement = movementRepository.save(movement);
        return movementMapper.movementToMovementDTO(updatedMovement);
    }

    public List<MovementDTO> findAll() {
        List<Movement> movements = movementRepository.findAll();
        return movementMapper.movementListToMovementDTOList(movements);
    }

    public MovementDTO findById(Long id) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new MovementNotFoundException(id));
        return movementMapper.movementToMovementDTO(movement);
    }

    public void deleteById(Long id) {
        movementRepository.deleteById(id);
    }

    private void validateBalanceAvailable(MovementDTO movementDTO, Account account) {
        if (movementDTO.getMovementType().equals("Retiro")) {
            if (account.getBalance() < Math.abs(movementDTO.getAmount())) {
                throw new BalanceNotAvailableException("Saldo no disponible");
            }
        }
    }
}
