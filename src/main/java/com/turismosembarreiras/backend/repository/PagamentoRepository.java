package com.turismosembarreiras.backend.repository;

import com.turismosembarreiras.backend.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}