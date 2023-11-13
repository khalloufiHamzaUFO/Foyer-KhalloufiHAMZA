package tn.esprit.twin6.foyerkhalloufihamza.service;

import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite u);
    List<Universite> addUniversites(List<Universite> universites);
    Universite editUniversite(Universite u);
    List<Universite> findAll();
    Universite findByIdU(long id);
    void deleteByIdU(long id);
    void delete(Universite u);
    Universite findUniversiteByNomUniversite(String s);

    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite(long idUniversite);
}
