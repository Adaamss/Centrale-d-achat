package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FactureAvoir implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer factureAvoirId;

    @JsonIgnore
    @ManyToOne()
    private Facture factureId;

    @JsonIgnore
    @ManyToOne()
    private Commande commandeId;

    private LocalDate dateFacturationAvoir;
    private Float prixTTC;
    private Integer etatFacture;
}
