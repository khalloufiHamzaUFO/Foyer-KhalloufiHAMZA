package tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories;

import org.springframework.cglib.core.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    List<Bloc> findBlocByNomBloc(String nomBloc);
//    List<Bloc> getBlocsByNomBlock(String nomBloc); X
    List<Bloc> findBlocByCapaciteBloc(long capacite);
    List<Bloc> findBlocByNomBlocAndCapaciteBloc(String s ,long l);
    List<Bloc> findBlocByNomBlocIgnoreCase(String s );
    List<Bloc> findByCapaciteBlocGreaterThan(long l );
    List<Bloc> findByNomBlocContaining(String subString);

    List<Bloc> findAllByOrderByNomBlocAsc();
    List<Bloc> findByNomBlocContainingOrCapaciteBloc(String nomBloc, long capaciteBloc);
    List<Bloc> findByFoyer(Foyer foyer);
    List<Bloc> findByFoyerUniversiteAndFoyerAndNomBloc(Universite universite, Foyer foyer, String nomBloc);
    //  List<Bloc> findByFoyerIdFoyer(long idF); X
    List<Bloc> findByNomBloc(String nomBloc);
    List<Bloc> findByCapaciteBloc(int capacity);
    List<Bloc> findBlocByNomBlocAndCapaciteBloc(String nomBloc , int capacity );
    List<Bloc> findBlocByCapaciteBlocGreaterThan(int capacity);
    List<Bloc> findBlocByNomBlocContaining(String nomBloc);
    List<Bloc> findAllByOrderByNomBloc();
    List<Bloc> findBlocByNomBlocOrCapaciteBloc(String nomBloc , int capacity);
    List<Bloc> findBlocByFoyer_Universite(Universite u);
    List<Bloc> findBlocByFoyer_UniversiteIdUniversite(long id);
    List<Bloc> getByNomBloc(String nomBloc);
    Bloc getBlocByNomBloc(String nomBlog);


}
