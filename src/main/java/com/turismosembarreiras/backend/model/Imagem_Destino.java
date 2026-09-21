package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagem_destino")
public class Imagem_Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    private Long idImagem;

    @Column(name = "id_destino")
    private Long idDestino;

    private String url;
    private String descricao;

  
    public Long getIdImagem() {
        return idImagem; 
    }
    public void setIdImagem(Long idImagem) {
        this.idImagem = idImagem;
    }
    public Long getIdDestino() { 
        return idDestino; 
    }
    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino; 
    }
    public String getUrl() {
        return url; 
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescricao() {
        return descricao; 
    }
    public void setDescricao(String descricao) { 
        this.descricao = descricao;
    }
}