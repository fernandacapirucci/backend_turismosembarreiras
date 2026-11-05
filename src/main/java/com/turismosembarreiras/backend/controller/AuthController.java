package com.turismosembarreiras.backend.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.turismosembarreiras.backend.dto.AuthResponse;
import com.turismosembarreiras.backend.dto.CadastroRequest;
import com.turismosembarreiras.backend.dto.GoogleLoginRequest;
import com.turismosembarreiras.backend.dto.LoginRequest;
import com.turismosembarreiras.backend.dto.UsuarioResponse;
import com.turismosembarreiras.backend.model.Usuario;
import com.turismosembarreiras.backend.repository.UsuarioRepository;
import com.turismosembarreiras.backend.security.JwtService;
import com.turismosembarreiras.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    @Value("${google.client-id}")
    private String googleClientId;

    public AuthController(AuthService authService, UsuarioRepository usuarioRepository,
                          JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<AuthResponse> cadastrar(@Valid @RequestBody CadastroRequest req) {
        Usuario u = authService.cadastrar(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(montarResposta(u));
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest req) {
        return montarResposta(authService.login(req));
    }

    @PostMapping("/google")
    public AuthResponse google(@Valid @RequestBody GoogleLoginRequest req) throws Exception {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                new NetHttpTransport(), GsonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList(googleClientId))
                .build();

        GoogleIdToken token = verifier.verify(req.idToken());
        if (token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token Google inválido");
        }

        String email = token.getPayload().getEmail();
        String nome = (String) token.getPayload().get("name");

        String tipo = "AGENCIA".equalsIgnoreCase(req.tipoUsuario()) ? "AGENCIA" : "VIAJANTE";

        Usuario u = usuarioRepository.findByEmail(email)
                .orElseGet(() -> authService.criarUsuarioComPerfil(nome, email, null, tipo, "GOOGLE"));

        return montarResposta(u);
    }

    private AuthResponse montarResposta(Usuario u) {
        String token = jwtService.gerar(u.getIdUsuario(), u.getEmail(), u.getTipoUsuario());
        return new AuthResponse(token, UsuarioResponse.de(u));
    }
}