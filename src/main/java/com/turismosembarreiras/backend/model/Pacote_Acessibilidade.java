package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pacote_acessibilidade")
public class Pacote_Acessibilidade {

    @EmbeddedId
    private PacoteAcessibilidadeId id;

    
    public PacoteAcessibilidadeId getId() { return id; }
    public void setId(PacoteAcessibilidadeId id) { this.id = id; }

    @Embeddable
    public static class PacoteAcessibilidadeId implements Serializable {
        @Column(name = "id_pacote")
        private Long idPacote;

        @Column(name = "id_acessibilidade")
        private Long idAcessibilidade;

        public Long getIdPacote() { return idPacote; }
        public void setIdPacote(Long idPacote) { this.idPacote = idPacote; }
        public Long getIdAcessibilidade() { return idAcessibilidade; }
        public void setIdAcessibilidade(Long idAcessibilidade) { this.idAcessibilidade = idAcessibilidade; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PacoteAcessibilidadeId)) return false;
            PacoteAcessibilidadeId that = (PacoteAcessibilidadeId) o;
            return Objects.equals(idPacote, that.idPacote) && Objects.equals(idAcessibilidade, that.idAcessibilidade);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idPacote, idAcessibilidade);
        }
    }
}