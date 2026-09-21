package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Agencia;
import com.turismosembarreiras.backend.repository.AgenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {

    private final AgenciaRepository repository;

    public AgenciaController(AgenciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Agencia> listarTodos() {
        return repository.findAll();
    }
}