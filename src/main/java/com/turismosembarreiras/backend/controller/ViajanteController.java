package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Usuario;
import com.turismosembarreiras.backend.model.Viajante;
import com.turismosembarreiras.backend.repository.UsuarioRepository;
import com.turismosembarreiras.backend.repository.ViajanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/viajantes")
public class ViajanteController {

    private final ViajanteRepository repository;
    private final UsuarioRepository usuarioRepository;

    public ViajanteController(ViajanteRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Viajante> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Viajante buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Viajante não encontrado"));
    }

    @PutMapping("/{id}")
    public Viajante atualizar(@PathVariable Long id, @RequestBody Viajante dados) {
        Viajante viajante = buscarPorId(id);

        viajante.setIdDeficiencia(dados.getIdDeficiencia());
        viajante.setTelefone(dados.getTelefone());
        viajante.setPossuiDeficiencia(dados.getPossuiDeficiencia());
        viajante.setNecessidadesAcessibilidade(dados.getNecessidadesAcessibilidade());

        return repository.save(viajante);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deletar(@PathVariable Long id) {
        Viajante viajante = buscarPorId(id);
        Usuario usuario = viajante.getUsuario();

        repository.delete(viajante);
        usuarioRepository.delete(usuario);
    }
}