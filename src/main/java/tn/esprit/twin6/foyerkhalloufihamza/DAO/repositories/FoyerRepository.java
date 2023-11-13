package tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    List<Foyer> findByBloc(Bloc bloc);
    List<Foyer> findFoyerByCapaciteFoyer(long capacity);
    Foyer findFoyerByUniversite(Universite u);
    Foyer findFoyerByNomFoyer(String nomFoyer);
}
