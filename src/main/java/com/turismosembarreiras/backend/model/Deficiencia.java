package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deficiencia")
public class Deficiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deficiencia")
    private Long idDeficiencia;

    private String nome;
    private String descricao;


    public Long getIdDeficiencia() {
        return idDeficiencia;
    }
    public void setIdDeficiencia(Long idDeficiencia) {
        this.idDeficiencia = idDeficiencia;
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