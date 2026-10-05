package com.turismosembarreiras.backend.dto;

import com.turismosembarreiras.backend.model.Usuario;

public record UsuarioResponse(
        Long idUsuario,
        String nome,
        String email,
        String tipoUsuario,
        String provedor
) {
    public static UsuarioResponse de(Usuario u) {
        return new UsuarioResponse(
                u.getIdUsuario(),
                u.getNome(),
                u.getEmail(),
                u.getTipoUsuario(),
                u.getProvedor()
        );
    }
}