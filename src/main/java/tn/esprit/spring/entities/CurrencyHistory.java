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
public class CurrencyHistory implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long currencyHistoryId;

    @JsonIgnore
    @ManyToOne()
    private Currency currencyId;

    private LocalDate dateUpdated;
    private Double exchangeRate;
}
