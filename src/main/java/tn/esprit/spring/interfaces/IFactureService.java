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
    public Facture getFactureById(Integer factureId);
    //public Float getGainsByDate(String dateFrom, String dateTo);
    //public Float getGainsByFacture(Facture facture);

}


