package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "id_viajante")
    private Long idViajante;

    @Column(name = "id_saida")
    private Long idSaida;

    @Column(name = "data_reserva")
    private LocalDate dataReserva;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "id_status")
    private Long status;

   
    public Long getIdReserva() { 
        return idReserva; 
    }
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva; 
    }
    public Long getIdViajante() { 
        return idViajante; 
    }
    public void setIdViajante(Long idViajante) {
        this.idViajante = idViajante;
    }
    public Long getIdSaida() { 
        return idSaida; 
    }
    public void setIdSaida(Long idSaida) { 
        this.idSaida = idSaida; 
    }
    public LocalDate getDataReserva() {
        return dataReserva;
    }
    public void setDataReserva(LocalDate dataReserva) { 
        this.dataReserva = dataReserva; 
    }
    public BigDecimal getValorTotal() {
        return valorTotal; 
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Long getStatus() { 
        return status; 
    }

    public void setStatus(Long status) { 
        this.status = status; 
    }
}