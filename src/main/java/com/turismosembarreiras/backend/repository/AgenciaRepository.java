package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Agencia;
import com.turismosembarreiras.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    Optional<Agencia> findByUsuario(Usuario usuario);
}