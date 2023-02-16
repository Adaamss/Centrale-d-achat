package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Offre;
@Repository
public interface OffreRepository extends JpaRepository<Offre,Integer> {

}
