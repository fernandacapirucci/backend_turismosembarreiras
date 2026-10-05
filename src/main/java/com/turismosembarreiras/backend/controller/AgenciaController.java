package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Agencia;
import com.turismosembarreiras.backend.model.Usuario;
import com.turismosembarreiras.backend.repository.AgenciaRepository;
import com.turismosembarreiras.backend.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {

    private final AgenciaRepository repository;
    private final UsuarioRepository usuarioRepository;

    public AgenciaController(AgenciaRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Agencia> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Agencia buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agência não encontrada"));
    }

    @PutMapping("/{id}")
    public Agencia atualizar(@PathVariable Long id, @RequestBody Agencia dados) {
        Agencia agencia = buscarPorId(id);

        agencia.setNomeSocial(dados.getNomeSocial());
        agencia.setNomeFantasia(dados.getNomeFantasia());
        agencia.setCnpj(dados.getCnpj());
        agencia.setTelefone(dados.getTelefone());
        agencia.setWhatsapp(dados.getWhatsapp());
        agencia.setCidade(dados.getCidade());
        agencia.setEstado(dados.getEstado());
        agencia.setDescricao(dados.getDescricao());

        return repository.save(agencia);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deletar(@PathVariable Long id) {
        Agencia agencia = buscarPorId(id);
        Usuario usuario = agencia.getUsuario();

        repository.delete(agencia);
        usuarioRepository.delete(usuario);
    }
}