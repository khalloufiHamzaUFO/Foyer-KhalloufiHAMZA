package tn.esprit.twin6.foyerkhalloufihamza.service;


import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer f);
    List<Foyer> addFoyers(List<Foyer> foyers);
    Foyer editFoyer(Foyer f);
    List<Foyer> findAll();
    Foyer findById(long id);
    void deleteByIdF(long id);
    void delete(Foyer c);
    List<Foyer> findByBlocs(Bloc bloc);

    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;


}
