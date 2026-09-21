package com.turismosembarreiras.backend.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reserva_passageiro")
public class Reserva_Passageiro {

    @EmbeddedId
    private ReservaPassageiroId id;

    @Column(name = "tipo_passageiro")
    private String tipoPassageiro;

    
    public ReservaPassageiroId getId() { 
        return id; 
    }

    public void setId(ReservaPassageiroId id) { 
        this.id = id; 
    }

    public String getTipoPassageiro() { 
        return tipoPassageiro; 
    }

    public void setTipoPassageiro(String tipoPassageiro) { 
        this.tipoPassageiro = tipoPassageiro; 
    }

    @Embeddable
    public static class ReservaPassageiroId implements Serializable {
        
        @Column(name = "id_reserva")
        private Long idReserva;

        @Column(name = "id_passageiro")
        private Long idPassageiro;

        public Long getIdReserva() { 
            return idReserva; 
        }

        public void setIdReserva(Long idReserva) { 
            this.idReserva = idReserva; 
        }

        public Long getIdPassageiro() { 
            return idPassageiro; 
        }

        public void setIdPassageiro(Long idPassageiro) { 
            this.idPassageiro = idPassageiro; 
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ReservaPassageiroId)) return false;
            ReservaPassageiroId that = (ReservaPassageiroId) o;
            return Objects.equals(idReserva, that.idReserva) && 
                   Objects.equals(idPassageiro, that.idPassageiro);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idReserva, idPassageiro);
        }
    }
}