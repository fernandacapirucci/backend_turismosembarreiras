package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {
    List<Pacote> findByIdAgencia(Long idAgencia);
}