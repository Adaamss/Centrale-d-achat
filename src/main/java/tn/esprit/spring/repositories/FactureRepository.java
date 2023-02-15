package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Facture;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Integer> {
    public List<Facture> findByDateFacturation(LocalDate date);
    public Facture findByCommandeId(Integer commandeId);
}