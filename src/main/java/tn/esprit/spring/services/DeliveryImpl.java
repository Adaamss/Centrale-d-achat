package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.interfaces.IDeliveryService;
import tn.esprit.spring.interfaces.IFactureService;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.repositories.DeliveryRepository;
import tn.esprit.spring.repositories.PaiementRepository;
import tn.esprit.spring.repositories.RetourRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class DeliveryImpl implements IDeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    RetourRepository retourRepository;

    @Override
    public void addDelivery(Livraison livraison) {
        deliveryRepository.save(livraison);
    }

    @Override
    public void EditDelivery(Livraison livraison, Integer livraisonId) {
        livraison.setLivraisonId(livraisonId);
        deliveryRepository.save(livraison);
    }

    @Override
    public void CancelDelivery(Retour retour, Integer livraisonId) {
        Livraison livraison = deliveryRepository.findById(livraisonId).orElse(null);
        livraison.setEtatLivraison(-1);
        deliveryRepository.save(livraison);
        retourRepository.save(retour);
    }

    @Override
    public List<Livraison> getDeliveries(){
        List<Livraison> listDeliveries = deliveryRepository.findAll();
        return listDeliveries;
    }

    @Override
    public List<Livraison> getDeliveriesByDate(String dateFrom, String dateTo){
        List<Livraison> listDeliveries = null;
        List<Livraison> deliveryTmp = null;
        LocalDate startDate = LocalDate.parse(dateFrom);
        LocalDate endDate = LocalDate.parse(dateTo);
        for(LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            deliveryTmp = deliveryRepository.findByDateLivraison(date);
            for (Livraison delivery : deliveryTmp){
                listDeliveries.add(delivery);
            }
        }
        return listDeliveries;
    }
    @Override
    public List<Retour> getCanceledDeliveries(){
        List<Retour> listCanceledDeliveries = retourRepository.findAll();
        return listCanceledDeliveries;
    }

}
