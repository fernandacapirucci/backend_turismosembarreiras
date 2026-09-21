package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Status_Reserva;
import com.turismosembarreiras.backend.repository.Status_ReservaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/status-reserva")
public class Status_ReservaController {

    private final Status_ReservaRepository repository;

    public Status_ReservaController(Status_ReservaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Status_Reserva> listarTodos() {
        return repository.findAll();
    }
}