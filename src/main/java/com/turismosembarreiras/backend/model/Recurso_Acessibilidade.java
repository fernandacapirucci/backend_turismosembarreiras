package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recurso_acessibilidade")
public class Recurso_Acessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acessibilidade")
    private Long idAcessibilidade;

    private String nome;
    private String descricao;

    
    public Long getIdAcessibilidade() { 
        return idAcessibilidade; 
    }

    public void setIdAcessibilidade(Long idAcessibilidade) { 
        this.idAcessibilidade = idAcessibilidade; 
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getDescricao() { 
        return descricao; 
    }

    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
}