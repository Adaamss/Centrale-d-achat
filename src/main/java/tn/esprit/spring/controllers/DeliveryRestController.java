package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Retour;
import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Paiement;
import tn.esprit.spring.interfaces.IDeliveryService;
import tn.esprit.spring.interfaces.IFactureService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/delivery")
public class DeliveryRestController {
	@Autowired
    IDeliveryService deliveryService;

	@PostMapping("/add-delivery")
	public void addDelivery(@RequestBody Livraison livraison) {
        deliveryService.addDelivery(livraison);
	};

    @PostMapping("/edit-delivery/{livraisonId}")
    public void editDelivery(@RequestBody Livraison livraison,
                             @PathVariable("livraisonId") Integer livraisonId){
        deliveryService.EditDelivery(livraison,livraisonId);
    }
	@GetMapping("/deliveries")
	public List<Livraison> getDeliveries() {
		return deliveryService.getDeliveries();
	}

	@GetMapping("/get-deliveries-by-date/{dateFrom}/{dateTo}")
	public List<Livraison> getDeliveriesByDate(@PathVariable("dateFrom") String dateFrom,
                                    @PathVariable("dateTo") String dateTo) {
		return deliveryService.getDeliveriesByDate(dateFrom,dateTo);
	}

}


