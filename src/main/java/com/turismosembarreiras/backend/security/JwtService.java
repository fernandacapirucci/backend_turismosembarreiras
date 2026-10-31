package com.turismosembarreiras.backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey chave;
    private final long expiracaoHoras;

    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expiracao-horas}") long expiracaoHoras) {
        if (secret.length() < 32) {
            throw new IllegalStateException("JWT_SECRET precisa ter pelo menos 32 caracteres");
        }
        this.chave = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expiracaoHoras = expiracaoHoras;
    }

    public String gerar(Long idUsuario, String email, String tipoUsuario) {
        Date agora = new Date();
        return Jwts.builder()
                .subject(String.valueOf(idUsuario))
                .claim("email", email)
                .claim("tipo", tipoUsuario)
                .issuedAt(agora)
                .expiration(new Date(agora.getTime() + Duration.ofHours(expiracaoHoras).toMillis()))
                .signWith(chave)
                .compact();
    }

    /** Devolve as claims do token ou null se for inválido/expirado. */
    public Claims validar(String token) {
        try {
            return Jwts.parser().verifyWith(chave).build().parseSignedClaims(token).getPayload();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }
}