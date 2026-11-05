package com.turismosembarreiras.backend.dto;

public record AuthResponse(String token, UsuarioResponse usuario) {}