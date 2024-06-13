package com.example.microserviceTransactions.application.mapper;

import com.example.microserviceTransactions.domain.model.Movement;
import com.example.microserviceTransactions.interfaces.dto.MovementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    @Mapping(source = "account.id", target = "accountId")
    MovementDTO movementToMovementDTO(Movement movement);

    @Mapping(source = "accountId", target = "account.id")
    Movement movementDTOToMovement(MovementDTO movementDTO);

    @Mapping(source = "accountId", target = "account.id")
    List<MovementDTO> movementListToMovementDTOList(List<Movement> movementsList);

    @Mapping(source = "accountId", target = "account.id")
    List<Movement> movementDTOListToMovementList(List<MovementDTO> movementsDTOList);

    @Mapping(target = "id", ignore = true)
    void updateMovementFromDTO(MovementDTO movementDTO, @MappingTarget Movement movement);
}