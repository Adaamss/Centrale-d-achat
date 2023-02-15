package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,Integer> {


}
