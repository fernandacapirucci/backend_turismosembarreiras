package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Reserva;
import com.turismosembarreiras.backend.repository.ReservaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaRepository repository;

    public ReservaController(ReservaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Reserva> listarTodos() {
        return repository.findAll();
    }
}