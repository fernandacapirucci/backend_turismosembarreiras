package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;

    
    public Long getIdUsuario() { 
        return idUsuario; 
    }

    public void setIdUsuario(Long idUsuario) { 
        this.idUsuario = idUsuario; 
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getSenha() { 
        return senha; 
    }

    public void setSenha(String senha) { 
        this.senha = senha; 
    }

    public String getTipoUsuario() { 
        return tipoUsuario; 
    }

    public void setTipoUsuario(String tipoUsuario) { 
        this.tipoUsuario = tipoUsuario; 
    }
}