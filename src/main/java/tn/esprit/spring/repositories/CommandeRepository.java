package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.User;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    public List<Commande> findByUserId(Integer userId);

}
