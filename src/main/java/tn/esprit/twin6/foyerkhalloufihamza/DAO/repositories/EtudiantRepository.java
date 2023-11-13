package tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Etudiant;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findEtudiantsByCin(long studentCIN);
    List<Etudiant> findEtudiantsByNomEtAndPrenomEt(String nom, String prenom);
    List<Etudiant> findEtudiantsByDateNaissanceAfter(LocalDate dateNaissance);
    List<Etudiant> findEtudiantByEcole(String schoolName);
//    List<Etudiant> findStudentsByReservationId(Reservation reservation);



}
