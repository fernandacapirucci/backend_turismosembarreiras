package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Usuario;
import com.turismosembarreiras.backend.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}