package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Cred;
@Repository
public interface CredRepository extends JpaRepository<Cred,Integer> {

}
