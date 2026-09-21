package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Pagamento;
import com.turismosembarreiras.backend.repository.PagamentoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoRepository repository;

    public PagamentoController(PagamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }
}