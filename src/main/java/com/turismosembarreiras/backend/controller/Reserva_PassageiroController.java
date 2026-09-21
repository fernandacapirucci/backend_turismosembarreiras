package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Reserva_Passageiro;
import com.turismosembarreiras.backend.repository.Reserva_PassageiroRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reserva-passageiro")
public class Reserva_PassageiroController {

    private final Reserva_PassageiroRepository repository;

    public Reserva_PassageiroController(Reserva_PassageiroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Reserva_Passageiro> listarTodos() {
        return repository.findAll();
    }
}