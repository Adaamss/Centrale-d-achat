package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.interfaces.IDeliveryService;
import tn.esprit.spring.interfaces.IOffreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/offre")
public class OffreRestController {
    @Autowired
    IOffreService iOffreService;
    @PostMapping("/add-offre")
    public void addOffre(@RequestBody Offre offre){
        iOffreService.addOffre(offre);
    }

    @GetMapping("/get-offre-by-id/{offreId}")
    public Offre getOffreById(@PathVariable("offreId") Integer offreId){
       return iOffreService.getOffreById(offreId);
    }



}
