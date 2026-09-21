package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}