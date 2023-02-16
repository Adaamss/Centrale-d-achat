package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.DemandeAchat;
@Repository
public interface DemandeAchatRepository extends JpaRepository<DemandeAchat,Integer> {
}
