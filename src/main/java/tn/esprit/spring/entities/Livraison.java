package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Livraison implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer livraisonId;

    @JsonIgnore
    @ManyToOne()
    private Commande commandeId;

    @JsonIgnore
    @ManyToOne()
    private Emplacement emplacementId;

    private LocalDate dateEnvoi;
    private LocalDate dateLivraisonPrevu;
    private LocalDate dateLivraison;
    private Integer typeLivraison;
    private String adresseLivraison;
    private Integer etatLivraison;
}
