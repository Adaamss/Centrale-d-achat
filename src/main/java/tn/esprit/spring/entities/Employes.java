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
public class Employes implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer employeId;

    @JsonIgnore
    @ManyToOne()
    private User userId;

    @JsonIgnore
    @ManyToOne()
    private EmplacementDepartement emplacementDeparetementId;

    private Integer fonction;


}
