package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    private Long idAvaliacao;

    @Column(name = "id_reserva")
    private Long idReserva;

    private Integer nota;
    private String comentario;

    @Column(name = "data_avaliacao")
    private LocalDate dataAvaliacao;

  
    public Long getIdAvaliacao() { 
        return idAvaliacao;
    }
    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao; 
    }
    public Long getIdReserva() {
        return idReserva; 
    }
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva; 
    }
    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) { 
        this.nota = nota;
    }
    public String getComentario() { 
        return comentario; 
    }
    public void setComentario(String comentario) { 
        this.comentario = comentario;
    }
    public LocalDate getDataAvaliacao() { 
        return dataAvaliacao; 
    }
    public void setDataAvaliacao(LocalDate dataAvaliacao) { 
        this.dataAvaliacao = dataAvaliacao; 
    }
}