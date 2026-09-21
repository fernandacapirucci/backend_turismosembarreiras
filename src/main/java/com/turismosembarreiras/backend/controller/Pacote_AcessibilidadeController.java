package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Pacote_Acessibilidade;
import com.turismosembarreiras.backend.repository.Pacote_AcessibilidadeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacote-acessibilidade")
public class Pacote_AcessibilidadeController {

    private final Pacote_AcessibilidadeRepository repository;

    public Pacote_AcessibilidadeController(Pacote_AcessibilidadeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pacote_Acessibilidade> listarTodos() {
        return repository.findAll();
    }
}