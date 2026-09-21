package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}