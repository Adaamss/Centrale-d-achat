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
public class Article implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer articleId;

    @JsonIgnore
    @ManyToOne()
    private TypeArticle typeArticleId;

    @JsonIgnore
    @ManyToOne()
    private Marque marqueId;

    private String nomArticle;
    private Integer seuilStock;
    private Float prixHT;
    private Integer typeCharge;
    private String photoArticle;   //src photo
    //                              ENAJMOU n7otou choix mta3 l charge kifeh bech ykoun mel ajout mta3 l article bidou
    //                              akeka ktoun pratique w dynimaque akther meli 3la kol commande takhtar menha na9sou
    //                              les fautes humaines w tkoun app adhka
}
