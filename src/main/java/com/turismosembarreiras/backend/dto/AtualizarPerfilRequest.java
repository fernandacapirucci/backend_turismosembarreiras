package com.turismosembarreiras.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record AtualizarPerfilRequest(@NotBlank String nome) {}