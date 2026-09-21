package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepository extends JpaRepository<Saida, Long> {
}