package tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findUniversiteByNomUniversite(String s);

}
