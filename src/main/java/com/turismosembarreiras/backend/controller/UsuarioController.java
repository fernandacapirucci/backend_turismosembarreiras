package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.dto.AtualizarPerfilRequest;
import com.turismosembarreiras.backend.dto.UsuarioResponse;
import com.turismosembarreiras.backend.model.Usuario;
import com.turismosembarreiras.backend.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    private Usuario logado(Authentication auth) {
        Long id = (Long) auth.getPrincipal();
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    // GET /usuarios/me  -> perfil de quem está logado
    @GetMapping("/me")
    public UsuarioResponse me(Authentication auth) {
        return UsuarioResponse.de(logado(auth));
    }

    // PUT /usuarios/me  -> atualiza o nome de quem está logado
    @PutMapping("/me")
    public UsuarioResponse atualizarMe(Authentication auth, @Valid @RequestBody AtualizarPerfilRequest body) {
        Usuario u = logado(auth);
        u.setNome(body.nome());
        return UsuarioResponse.de(repository.save(u));
    }
}