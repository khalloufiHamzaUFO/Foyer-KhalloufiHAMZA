package tn.esprit.twin6.foyerkhalloufihamza.service;

import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Repository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;

import java.util.List;

@Repository
public interface IBlocService {
    Bloc addBloc(Bloc b);
    Bloc editBloc(Bloc b);
    List<Bloc> addBlocs(List<Bloc> blocs);
    List<Bloc> findAll();
    Bloc findById(long id);
    void deleteById(long id);
    void delete(Bloc b);
    List<Bloc>findBlocByNomBloc(String s);
    List<Bloc>findBlocByCapaciteBloc(long l);
    List<Bloc>findBlocByNomBlocAndCapaciteBloc(String s,long l);
    List<Bloc>findBlocByNomBlocIgnoreCase(String s);
    List<Bloc> findByCapaciteBlocGreaterThan(long l );
    List<Bloc> findByNomBlocContaining(String subString);

    List<Bloc> findAllByOrderByNomBlocAsc();
    List<Bloc> findByNomBlocContainingOrCapaciteBloc(String nomBloc, long capaciteBloc);
    List<Bloc> findByFoyer(Foyer foyer);
    List<Bloc> findByFoyerUniversiteAndFoyerAndNomBloc(Universite universite, Foyer foyer, String nomBloc);

    Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) ;
    Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer) ;
}
