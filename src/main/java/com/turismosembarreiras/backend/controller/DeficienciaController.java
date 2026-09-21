package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Deficiencia;
import com.turismosembarreiras.backend.repository.DeficienciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deficiencias")
public class DeficienciaController {

    private final DeficienciaRepository repository;

    public DeficienciaController(DeficienciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Deficiencia> listarTodos() {
        return repository.findAll();
    }
}