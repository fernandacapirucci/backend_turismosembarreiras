package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

}