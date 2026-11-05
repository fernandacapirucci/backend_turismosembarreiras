package com.turismosembarreiras.backend.dto;

import jakarta.validation.constraints.NotBlank;

/** tipoUsuario é opcional: só vale na primeira vez (criação da conta). Padrão: VIAJANTE. */
public record GoogleLoginRequest(
        @NotBlank String idToken,
        String tipoUsuario
) {}