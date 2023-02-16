package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Retour;
import tn.esprit.spring.interfaces.IRetourService;
import tn.esprit.spring.repositories.DeliveryRepository;
import tn.esprit.spring.repositories.RetourRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class RetourImpl implements IRetourService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    RetourRepository retourRepository;


    @Override
    public void CancelDelivery(Retour retour, Integer livraisonId) {
        Livraison livraison = deliveryRepository.findById(livraisonId).orElse(null);
        livraison.setEtatLivraison(-1);
        retour.setLivraisonId(livraison);
        deliveryRepository.save(livraison);
        retourRepository.save(retour);
    }

    @Override
    public List<Retour> getCanceledDeliveries(){
        List<Retour> listCanceledDeliveries = retourRepository.findAll();
        return listCanceledDeliveries;
    }

}
