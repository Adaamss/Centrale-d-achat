package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Livraison;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Livraison,Integer> {

    public List<Livraison> findByDateLivraison(LocalDate date);

}
