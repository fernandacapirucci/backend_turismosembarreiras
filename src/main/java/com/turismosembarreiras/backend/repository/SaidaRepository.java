package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaidaRepository extends JpaRepository<Saida, Long> {
    List<Saida> findByIdPacote(Long idPacote);
    boolean existsByIdPacote(Long idPacote);
}