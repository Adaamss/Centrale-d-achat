package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.FactureAvoir;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.interfaces.IPaiementService;
import tn.esprit.spring.repositories.CommandeRepository;
import tn.esprit.spring.repositories.FactureAvoirRepository;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.repositories.PaiementRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class PaiementImpl implements IPaiementService {

    @Autowired
    PaiementRepository paiementRepository;

    @Autowired
    FactureAvoirRepository factureAvoirRepository;

    @Autowired
    FactureRepository factureRepository;
    @Autowired
    CommandeRepository commandeRepository;


   //@Scheduled(fixedRate = 300000) ou bien
  //@Scheduled(cron = "*/30 * * * * *")
/*
    @Override
    public void getNbrStudentByFormation() {

        List<Commande> listCommande =  factureRepository.findAll();

        listCommande.forEach(formation -> {
            log.info("La formation  "+ formation.getTitle()+" contient : "+ formation.getListFactures().size()+ "apprenants");
        });

    }

    @Override
    public Integer getProfessorRemunerationByDate(Integer idProfessor, LocalDate dateDebut, LocalDate dateFin) {
    Integer somme = 0;
        Paiement paiement = deliveryRepository.findById(idProfessor).orElse(null);
        for (Commande commande : paiement.getListCommandes()){
            if(commande.getDateDebut().isAfter(dateDebut) && commande.getDateFin().isBefore(dateFin)){
                somme +=  commande.getNbHeure()* commande.getPaiement().getTarifHoraire();
            }
        }
        return somme;
    }

    @Override
    public Integer getRevenuByFormation(Integer idFormation) {
        Commande commande = factureRepository.findById(idFormation).orElse(null);
      return  commande.getListFactures().size() * commande.getFrais();
    }
    
    public List<Paiement> getProfessor() {
        List<Paiement> listPaiement =  deliveryRepository.findAll();
        return listPaiement;
    }

    public List<Commande> getFormations() {
        List<Commande> listCommande =  factureRepository.findAll();
        return listCommande;
    }

    public List<Facture> getStudents() {
        List<Facture> listFacture =  paiementRepository.findAll();
        return listFacture;
    }*/
}
