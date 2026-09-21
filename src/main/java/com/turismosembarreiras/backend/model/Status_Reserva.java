package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "status_reserva")
public class Status_Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long idStatus;

    private String descricao;

    
    public Long getIdStatus() { 
        return idStatus; 
    }

    public void setIdStatus(Long idStatus) { 
        this.idStatus = idStatus; 
    }

    public String getDescricao() { 
        return descricao; 
    }

    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
}