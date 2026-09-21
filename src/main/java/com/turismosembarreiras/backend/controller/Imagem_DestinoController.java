package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Imagem_Destino;
import com.turismosembarreiras.backend.repository.Imagem_DestinoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagem-destinos")
public class Imagem_DestinoController {

    private final Imagem_DestinoRepository repository;

    public Imagem_DestinoController(Imagem_DestinoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Imagem_Destino> listarTodos() {
        return repository.findAll();
    }
}