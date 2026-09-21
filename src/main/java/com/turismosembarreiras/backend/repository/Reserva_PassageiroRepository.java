package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Reserva_Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reserva_PassageiroRepository extends JpaRepository<Reserva_Passageiro, Reserva_Passageiro.ReservaPassageiroId> {
}