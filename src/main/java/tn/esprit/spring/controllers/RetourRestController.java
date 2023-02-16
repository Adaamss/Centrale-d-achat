package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Retour;
import tn.esprit.spring.interfaces.IDeliveryService;
import tn.esprit.spring.interfaces.IRetourService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/retour")
public class RetourRestController {
	@Autowired
    IRetourService retourService;

    @PostMapping("/cancel-delivery/{livraisonId}")
    public void cancelDelivery(@RequestBody Retour retour,
                               @PathVariable("livraisonId") Integer livraisonId){
        retourService.CancelDelivery(retour,livraisonId);
    }
    @GetMapping("/canceled-deliveries")
    public List<Retour> getCanceledDeliveries() {
        return retourService.getCanceledDeliveries();
    }


}


