package tn.esprit.twin6.foyerkhalloufihamza.service;


import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Chambre;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre c);
    List<Chambre> addChambres(List<Chambre> chambres);
    Chambre editChambre(Chambre c);
    List<Chambre> findAll();
    Chambre findById(long id);
    void deleteByIdC(long id);
    void delete(Chambre c);
    List<Chambre> findByNumeroChambreOrTypeC(long num, TypeChambre type);
    List<Chambre> findByNumeroChambre(long n);
    List<Chambre> findByTypeC(TypeChambre t);
    List<Chambre> findByNumeroChambreAndTypeC(long numeroChambre, TypeChambre type);
    List<Chambre> findByBloc(Bloc bloc);
    List<Chambre> findChambresByBlocAndTypeC( Bloc bloc, TypeChambre typeC);

    List<Chambre> getChambresParNomBloc( String nomBloc) ;
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type) ;
    long nbChambreParTypeEtBloc( TypeChambre type, long idBloc) ;
}
