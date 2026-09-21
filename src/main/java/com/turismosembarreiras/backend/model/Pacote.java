package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pacote")
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pacote")
    private Long idPacote;

    @Column(name = "id_agencia")
    private Long idAgencia;

    @Column(name = "id_destino")
    private Long idDestino;

    private String titulo;
    private String descricao;
    private String duracao;
    private BigDecimal preco;
    private String incluso;

    
    public Long getIdPacote() { 
        return idPacote;
    }
    public void setIdPacote(Long idPacote) { 
        this.idPacote = idPacote; 
    }
    public Long getIdAgencia() { 
        return idAgencia; 
    }
    public void setIdAgencia(Long idAgencia) { 
        this.idAgencia = idAgencia; 
    }
    public Long getIdDestino() { 
        return idDestino; 
    }
    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino; 
    }
    public String getTitulo() {
        return titulo; 
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo; 
    }
    public String getDescricao() {
        return descricao; 
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDuracao() { 
        return duracao; 
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao; 
    }
    public BigDecimal getPreco() {
        return preco; 
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco; 
    }
    public String getIncluso() {
        return incluso; 
    }
    public void setIncluso(String incluso) {
        this.incluso = incluso; 
    }
}