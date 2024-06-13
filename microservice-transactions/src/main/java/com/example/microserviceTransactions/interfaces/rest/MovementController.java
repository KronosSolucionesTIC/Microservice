package com.example.microserviceTransactions.interfaces.rest;

import com.example.microserviceTransactions.application.service.MovementService;
import com.example.microserviceTransactions.interfaces.dto.MovementDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovementController {
    private MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllMovements() {
        try {
            List<MovementDTO> movements = movementService.findAll();
            return ResponseEntity.ok(movements);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting movements: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getMovementById(@PathVariable Long id) {
        try {
            MovementDTO movement = movementService.findById(id);
            return ResponseEntity.ok(movement);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting movement: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createMovement(@RequestBody @Valid MovementDTO movementDTO) {
        try {
            MovementDTO movement = movementService.createMovement(movementDTO);
            return ResponseEntity.ok(movement);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating movement: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateMovement(@PathVariable Long id, @RequestBody MovementDTO movementDTO) {
        try {
            MovementDTO updatedMovement = movementService.updateMovement(id, movementDTO);
            return ResponseEntity.ok(updatedMovement);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating movement: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMovement(@PathVariable Long id) {
        try {
            movementService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting movement: " + e.getMessage());
        }
    }
}
