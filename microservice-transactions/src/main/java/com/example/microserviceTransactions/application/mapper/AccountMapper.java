package com.example.microserviceTransactions.application.mapper;

import com.example.microserviceTransactions.domain.model.Account;
import com.example.microserviceTransactions.interfaces.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO accountToAccountDTO(Account account);

    Account accountDTOToAccount(AccountDTO accountDTO);

    List<AccountDTO> accountListToAccountDTOList(List<Account> accountsList);

    List<Account> accountDTOListToAccountList(List<AccountDTO> accountsDTOList);

    @Mapping(target = "id", ignore = true)
    void updateAccountFromDTO(AccountDTO accountDTO, @MappingTarget Account account);
}

