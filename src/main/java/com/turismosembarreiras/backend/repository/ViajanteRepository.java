package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Viajante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajanteRepository extends JpaRepository<Viajante, Long> {
}