package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Saida;
import com.turismosembarreiras.backend.repository.SaidaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/saidas")
public class SaidaController {

    private final SaidaRepository repository;

    public SaidaController(SaidaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Saida> listarTodos() {
        return repository.findAll();
    }
}