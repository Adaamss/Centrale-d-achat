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
public class Offre implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer offreId;

    @JsonIgnore
    @ManyToOne()
    private AppelOffre appelOffreId;

    @JsonIgnore
    @ManyToOne()
    private User userId;
    private String descOffre;
    private LocalDate dateOffre;
    private Integer etatOffre;
}
