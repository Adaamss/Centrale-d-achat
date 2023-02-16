package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.interfaces.IOffreService;
import tn.esprit.spring.repositories.OffreRepository;

import java.util.List;

@Service
@Slf4j
public class OffreImpl implements IOffreService {
    @Autowired
    OffreRepository offreRepository;




    @Override
    public void addOffre(Offre offre) {
        offreRepository.save(offre);

    }

    @Override
    public Offre getOffreById(Integer offreId) {
        Offre offre = offreRepository.findById(offreId).orElse(null);
        return  offre;
    }


}
