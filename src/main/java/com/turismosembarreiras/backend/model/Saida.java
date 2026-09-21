package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "saida")
public class Saida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_saida")
    private Long idSaida;

    @Column(name = "id_pacote")
    private Long idPacote;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "data_retorno")
    private LocalDate dataRetorno;

    @Column(name = "vagas_total")
    private Integer vagasTotal;

    @Column(name = "vagas_disponiveis")
    private Integer vagasDisponiveis;

    private BigDecimal preco;

    
    public Long getIdSaida() { 
        return idSaida; 
    }

    public void setIdSaida(Long idSaida) { 
        this.idSaida = idSaida; 
    }

    public Long getIdPacote() { 
        return idPacote; 
    }

    public void setIdPacote(Long idPacote) { 
        this.idPacote = idPacote; 
    }

    public LocalDate getDataSaida() { 
        return dataSaida; 
    }

    public void setDataSaida(LocalDate dataSaida) { 
        this.dataSaida = dataSaida; 
    }

    public LocalDate getDataRetorno() { 
        return dataRetorno; 
    }

    public void setDataRetorno(LocalDate dataRetorno) { 
        this.dataRetorno = dataRetorno; 
    }

    public Integer getVagasTotal() { 
        return vagasTotal; 
    }

    public void setVagasTotal(Integer vagasTotal) { 
        this.vagasTotal = vagasTotal; 
    }

    public Integer getVagasDisponiveis() { 
        return vagasDisponiveis; 
    }

    public void setVagasDisponiveis(Integer vagasDisponiveis) { 
        this.vagasDisponiveis = vagasDisponiveis; 
    }

    public BigDecimal getPreco() { 
        return preco; 
    }

    public void setPreco(BigDecimal preco) { 
        this.preco = preco; 
    }
}