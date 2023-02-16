package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.interfaces.IFactureService;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	IFactureService FactureImpl;

	@PostMapping("/add-facture")
	public void addFacture(@RequestBody Facture facture) {
		FactureImpl.addFacture(facture);
	};

	@GetMapping("/get-facture-by-date/{dateFrom}/{dateTo}")
	public List<Facture> getFacturesByDate(@PathVariable("dateFrom") String dateFrom,
										   @PathVariable("dateTo") String dateTo) {
		return FactureImpl.getFacturesByDate(dateFrom, dateTo);
	}

	@GetMapping("/get-facture-by-commande/{commandeId}")
	public Facture getFactureByCommande(@PathVariable("commandeId") Integer commandeId){
		return FactureImpl.getFactureByCommande(commandeId);
	}

	@GetMapping("/get-facture-by-user")
	public List<Facture> getFactureByUser(@RequestBody User user){
		return FactureImpl.getFacturesByUser(user);
	}

	@GetMapping("/get-facture-by-facture-avoir")
	public Facture getFactureByFactureAvoir(@RequestBody FactureAvoir factureAvoir){
		return FactureImpl.getFactureByFactureAvoir(factureAvoir);
	}

	@GetMapping("/factures")
	public List<Facture> getFactures() {
		return FactureImpl.getFactures();
	}

}


