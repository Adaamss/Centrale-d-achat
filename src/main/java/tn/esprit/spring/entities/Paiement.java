package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Paiement implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer paiementId;

    @JsonIgnore
    @ManyToOne()
    private Facture factureId;

    private Integer methodePaiement;
    private Integer etatPaiement;
}
