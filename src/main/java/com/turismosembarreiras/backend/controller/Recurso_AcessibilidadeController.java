package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Recurso_Acessibilidade;
import com.turismosembarreiras.backend.repository.Recurso_AcessibilidadeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/recursos-acessibilidade")
public class Recurso_AcessibilidadeController {

    private final Recurso_AcessibilidadeRepository repository;

    public Recurso_AcessibilidadeController(Recurso_AcessibilidadeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Recurso_Acessibilidade> listarTodos() {
        return repository.findAll();
    }
}