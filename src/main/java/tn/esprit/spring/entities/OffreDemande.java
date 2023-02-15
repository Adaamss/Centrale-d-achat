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
public class OffreDemande implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer offreDemandeId;

    @JsonIgnore
    @ManyToOne()
    private User userId;

    @JsonIgnore
    @ManyToOne()
    private DemandeAchat demandeAchatId;

    private LocalDate dateOD;
    private Integer statusOD;
}
