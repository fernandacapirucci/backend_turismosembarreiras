package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Pacote;
import com.turismosembarreiras.backend.repository.PacoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    private final PacoteRepository repository;

    public PacoteController(PacoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pacote> listarTodos() {
        return repository.findAll();
    }
}