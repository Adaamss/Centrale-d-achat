package tn.esprit.spring.interfaces;


import net.bytebuddy.asm.Advice;
import tn.esprit.spring.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IFactureService {
    public void addFacture (Facture facture);
    public List<Facture> getFacturesByDate(String dateFrom, String dateTo);
    public Facture getFactureByCommande(Commande commande);
    public List<Facture> getFacturesByUser(User user);
    public Facture getFactureByFactureAvoir(FactureAvoir factureAvoir);
    public List<Facture> getFactures ();
    //public Float getGainsByDate(String dateFrom, String dateTo);
    //public Float getGainsByFacture(Facture facture);

    public void addFactureAvoir (FactureAvoir factureAvoir, Integer idFacture); // ajoute une facture avoir et change l'etat de la facture original
    public List<FactureAvoir> getFacturesAvoir();
    public List<FactureAvoir> getFacturesAvoirByDate(String dateFrom, String dateTo);
    public Integer countFacturesAvoirByDate(String dateFrom, String dateTo);

    /*public void addPaiement(Paiement paiement);
    public List<Paiement> getPaiement();
    public Paiement getPaiementByFacture(Facture facture);
    public List<Paiement> getPaiementsByUser(User user);
    public List<Paiement> getPaiementsByDate(String dateFrom, String dateTo);
    public List<Paiement> getRevertedPaiements();
    */
}


