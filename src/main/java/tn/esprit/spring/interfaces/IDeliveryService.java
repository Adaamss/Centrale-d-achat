package tn.esprit.spring.interfaces;


import tn.esprit.spring.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IDeliveryService {
    public void addDelivery (Livraison livraison);
    public void EditDelivery (Livraison livraison, Integer livraisonId);
    public void CancelDelivery (Retour retour, Integer livraisonId);
    public List<Livraison> getDeliveries();
    public List<Livraison> getDeliveriesByDate(String dateFrom, String dateTo);
    public List<Retour> getCanceledDeliveries();
}

