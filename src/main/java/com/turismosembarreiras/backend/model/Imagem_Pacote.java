package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagem_pacote")
public class Imagem_Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    private Long idImagem;

    @Column(name = "id_pacote")
    private Long idPacote;

    private String url;
    private String descricao;

  
    public Long getIdImagem() { 
        return idImagem;
    }
    public void setIdImagem(Long idImagem) {
        this.idImagem = idImagem; 
    }
    public Long getIdPacote() {
        return idPacote;
    }
    public void setIdPacote(Long idPacote) { 
        this.idPacote = idPacote; 
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