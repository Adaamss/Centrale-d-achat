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
public class Publication implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer publicationId;

    @JsonIgnore
    @ManyToOne()
    private User userId;

    @JsonIgnore
    @ManyToOne()
    private Rubrique rubriqueId;

    private LocalDate datePublication;
    private Long likes;
    private String titrePublication;
    private String contenu;

}
