package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Passageiro;
import com.turismosembarreiras.backend.repository.PassageiroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    private final PassageiroRepository repository;

    public PassageiroController(PassageiroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Passageiro> listarTodos() {
        return repository.findAll();
    }
}