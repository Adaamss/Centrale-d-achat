package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Offre;

import java.util.List;

public interface IOffreService {
    public void addOffre(Offre offre);
    public Offre getOffreById(Integer offreId);
}
