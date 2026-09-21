package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passageiro")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passageiro")
    private Long idPassageiro;

    @Column(name = "id_deficiencia")
    private Long idDeficiencia;

    @Column(name = "primeiro_nome")
    private String primeiroNome;

    @Column(name = "ultimo_nome")
    private String ultimoNome;

    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String nacionalidade;
    private String genero;

    @Column(name = "possui_deficiencia")
    private Boolean possuiDeficiencia;

    
    public Long getIdPassageiro() { 
        return idPassageiro; 
    }
    
    public void setIdPassageiro(Long idPassageiro) { 
        this.idPassageiro = idPassageiro; 
    }
    
    public Long getIdDeficiencia() { 
        return idDeficiencia; 
    }
    
    public void setIdDeficiencia(Long idDeficiencia) { 
        this.idDeficiencia = idDeficiencia; 
    }
    
    public String getPrimeiroNome() { 
        return primeiroNome; 
    }
    
    public void setPrimeiroNome(String primeiroNome) { 
        this.primeiroNome = primeiroNome; 
    }
    
    public String getUltimoNome() { 
        return ultimoNome; 
    }
    
    public void setUltimoNome(String ultimoNome) { 
        this.ultimoNome = ultimoNome; 
    }
    
    public String getCpf() { 
        return cpf; 
    }
    
    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    }
    
    public LocalDate getDataNascimento() { 
        return dataNascimento; 
    }
    
    public void setDataNascimento(LocalDate dataNascimento) { 
        this.dataNascimento = dataNascimento; 
    }
    
    public String getNacionalidade() { 
        return nacionalidade; 
    }
    
    public void setNacionalidade(String nacionalidade) { 
        this.nacionalidade = nacionalidade; 
    }
    
    public String getGenero() { 
        return genero; 
    }
    
    public void setGenero(String genero) { 
        this.genero = genero; 
    }
    
    public Boolean getPossuiDeficiencia() { 
        return possuiDeficiencia; 
    }
    
    public void setPossuiDeficiencia(Boolean possuiDeficiencia) { 
        this.possuiDeficiencia = possuiDeficiencia; 
    }
}