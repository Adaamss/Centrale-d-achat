package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.FactureAvoir;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.interfaces.IFactureService;
import tn.esprit.spring.repositories.CommandeRepository;
import tn.esprit.spring.repositories.FactureAvoirRepository;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.repositories.PaiementRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FactureImpl implements IFactureService {

    @Autowired
    PaiementRepository paiementRepository;

    @Autowired
    FactureAvoirRepository factureAvoirRepository;

    @Autowired
    FactureRepository factureRepository;
    @Autowired
    CommandeRepository commandeRepository;
    @Override
    public void addFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public List<Facture> getFacturesByDate(String dateFrom, String dateTo){
        List<Facture> listFactures = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(dateFrom);
        LocalDate endDate = LocalDate.parse(dateTo);
        for(LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            log.info(String.valueOf(date));
            List<Facture> factureTmp = factureRepository.findAllByDateFacturation(date);
            log.info(String.valueOf(factureTmp.isEmpty()));
            log.info(factureTmp.toString());
            if(factureTmp.isEmpty()==false) {
                for (Facture facture : factureTmp) {
                    listFactures.add(facture);
                }
            }
            factureTmp = null;
        }
        return listFactures;
    }

    @Override
    public Facture getFactureById(Integer factureId){
        Facture facture = factureRepository.findById(factureId).orElse(null);
        return facture;
    }
    @Override
    public Facture getFactureByCommande(Integer commandeId){
        Commande commande = commandeRepository.findById(commandeId).orElse(null);
        List<Commande> lc = commandeRepository.findAll();
        log.info(lc.toString());
        log.info(commandeId.toString());
        log.info(commande.toString());
        log.info("fin des tests");
        Facture facture = factureRepository.findByCommandeId(commande);
        log.info(facture.toString());
        return facture;
    }

    @Override
    public List<Facture> getFacturesByUser(User user){
        Facture facture;
        List<Facture> listFactures = null;
        List<Commande> listCmd = commandeRepository.findByUserId(user.getUserId());
        for(Commande cmd:listCmd){
            facture = factureRepository.findById(cmd.getCommandeId()).orElse(null);
            listFactures.add(facture);
        }
        return listFactures;
    }

    @Override
    public Facture getFactureByFactureAvoir(FactureAvoir factureAvoir){
        Facture facture = factureRepository.findById(factureAvoir.getFactureId().getFactureId()).orElse(null);
        return facture;
    }

    @Override
    public List<Facture> getFactures(){
        List<Facture> listFactures = factureRepository.findAll();
        return listFactures;
    }

   /* @Override
    public Float getGainsByDate(String dateFrom, String dateTo){
        Float gains= Float.valueOf(0);
        List<Facture> listFactures = null;
        List<Facture> factureTmp = null;
        LocalDate startDate = LocalDate.parse(dateFrom);
        LocalDate endDate = LocalDate.parse(dateTo);
        for(LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            factureTmp = factureRepository.findByDateFacturation(date);
            for (Facture facture : factureTmp){
                listFactures.add(facture);
            }
        }
        for(Facture f:listFactures){
            gains=f.
        }
        return listFactures;
    }*/



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
