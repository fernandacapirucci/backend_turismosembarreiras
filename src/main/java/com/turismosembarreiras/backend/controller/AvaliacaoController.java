package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Avaliacao;
import com.turismosembarreiras.backend.repository.AvaliacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoRepository repository;

    public AvaliacaoController(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Avaliacao> listarTodos() {
        return repository.findAll();
    }
}