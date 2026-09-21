package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Pacote_Acessibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pacote_AcessibilidadeRepository extends JpaRepository<Pacote_Acessibilidade, Pacote_Acessibilidade.PacoteAcessibilidadeId> {
}