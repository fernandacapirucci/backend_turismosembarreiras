package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Viajante;
import com.turismosembarreiras.backend.repository.ViajanteRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/viajantes")
public class ViajanteController {

    private final ViajanteRepository repository;

    public ViajanteController(ViajanteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Viajante> listarTodos() {
        return repository.findAll();
    }
}