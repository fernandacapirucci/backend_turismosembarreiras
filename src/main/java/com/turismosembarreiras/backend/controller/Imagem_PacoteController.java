package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Imagem_Pacote;
import com.turismosembarreiras.backend.repository.Imagem_PacoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagem-pacotes")
public class Imagem_PacoteController {

    private final Imagem_PacoteRepository repository;

    public Imagem_PacoteController(Imagem_PacoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Imagem_Pacote> listarTodos() {
        return repository.findAll();
    }
}