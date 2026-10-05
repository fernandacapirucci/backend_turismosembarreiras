package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Usuario;
import com.turismosembarreiras.backend.model.Viajante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViajanteRepository extends JpaRepository<Viajante, Long> {
    Optional<Viajante> findByUsuario(Usuario usuario);
}