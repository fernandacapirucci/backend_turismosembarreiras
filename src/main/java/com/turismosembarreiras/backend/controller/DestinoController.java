package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Destino;
import com.turismosembarreiras.backend.repository.DestinoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    private final DestinoRepository repository;

    public DestinoController(DestinoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Destino> listarTodos() {
        return repository.findAll();
    }
}