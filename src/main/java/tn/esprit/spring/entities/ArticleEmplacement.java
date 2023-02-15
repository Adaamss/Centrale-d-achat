package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEmplacement implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer articleEmplacementId;

    @JsonIgnore
    @ManyToOne()
    private Emplacement emplacementId;

    @JsonIgnore
    @ManyToOne()
    private Article articleId;

    private Integer stockE;
}
