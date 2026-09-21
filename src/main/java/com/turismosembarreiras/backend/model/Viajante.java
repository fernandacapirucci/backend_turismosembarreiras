package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "viajante")
public class Viajante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viajante")
    private Long idViajante;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_deficiencia")
    private Long idDeficiencia;

    private String telefone;

    @Column(name = "possui_deficiencia")
    private Boolean possuiDeficiencia;

    @Column(name = "necessidades_acessibilidade")
    private String necessidadesAcessibilidade;

    
    public Long getIdViajante() { 
        return idViajante; 
    }

    public void setIdViajante(Long idViajante) { 
        this.idViajante = idViajante; 
    }

    public Long getIdUsuario() { 
        return idUsuario; 
    }

    public void setIdUsuario(Long idUsuario) { 
        this.idUsuario = idUsuario; 
    }

    public Long getIdDeficiencia() { 
        return idDeficiencia; 
    }

    public void setIdDeficiencia(Long idDeficiencia) { 
        this.idDeficiencia = idDeficiencia; 
    }

    public String getTelefone() { 
        return telefone; 
    }

    public void setTelefone(String telefone) { 
        this.telefone = telefone; 
    }

    public Boolean getPossuiDeficiencia() { 
        return possuiDeficiencia; 
    }

    public void setPossuiDeficiencia(Boolean possuiDeficiencia) { 
        this.possuiDeficiencia = possuiDeficiencia; 
    }

    public String getNecessidadesAcessibilidade() { 
        return necessidadesAcessibilidade; 
    }

    public void setNecessidadesAcessibilidade(String necessidadesAcessibilidade) { 
        this.necessidadesAcessibilidade = necessidadesAcessibilidade; 
    }
}