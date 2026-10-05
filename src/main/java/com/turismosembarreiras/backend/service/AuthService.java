package com.turismosembarreiras.backend.service;

import com.turismosembarreiras.backend.dto.CadastroRequest;
import com.turismosembarreiras.backend.dto.LoginRequest;
import com.turismosembarreiras.backend.model.Agencia;
import com.turismosembarreiras.backend.model.Usuario;
import com.turismosembarreiras.backend.model.Viajante;
import com.turismosembarreiras.backend.repository.AgenciaRepository;
import com.turismosembarreiras.backend.repository.UsuarioRepository;
import com.turismosembarreiras.backend.repository.ViajanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final ViajanteRepository viajanteRepository;
    private final AgenciaRepository agenciaRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, ViajanteRepository viajanteRepository,
                       AgenciaRepository agenciaRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.viajanteRepository = viajanteRepository;
        this.agenciaRepository = agenciaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario cadastrar(CadastroRequest req) {
        String tipo = req.tipoUsuario().toUpperCase();
        if (!tipo.equals("VIAJANTE") && !tipo.equals("AGENCIA")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "tipoUsuario deve ser VIAJANTE ou AGENCIA");
        }
        if (usuarioRepository.findByEmail(req.email()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
        }
        return criarUsuarioComPerfil(req.nome(), req.email(),
                passwordEncoder.encode(req.senha()), tipo, "LOCAL");
    }

    @Transactional
    public Usuario criarUsuarioComPerfil(String nome, String email, String senhaHash, String tipo, String provedor) {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senhaHash);
        u.setTipoUsuario(tipo);
        u.setProvedor(provedor);
        usuarioRepository.save(u);

        if (tipo.equals("AGENCIA")) {
            Agencia a = new Agencia();
            a.setUsuario(u);
            agenciaRepository.save(a);
        } else {
            Viajante v = new Viajante();
            v.setUsuario(u);
            viajanteRepository.save(v);
        }
        return u;
    }

    public Usuario login(LoginRequest req) {
        Usuario u = usuarioRepository.findByEmail(req.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou senha inválidos"));

        if (u.getSenha() == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Esta conta usa login com Google");
        }
        if (!passwordEncoder.matches(req.senha(), u.getSenha())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou senha inválidos");
        }
        return u;
    }
}