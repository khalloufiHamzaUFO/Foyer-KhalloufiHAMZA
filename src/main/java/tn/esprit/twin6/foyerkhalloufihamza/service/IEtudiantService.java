package tn.esprit.twin6.foyerkhalloufihamza.service;

import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Etudiant;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant e);
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant editEtudiant(Etudiant e);
    List<Etudiant> findAll();
    Etudiant findById(long id);
    void deleteByIdE(long id);
    void delete(Etudiant e);
    List<Etudiant> findEtudiantsByCin(long studentCIN);
    List<Etudiant> findEtudiantsByNomEtAndPrenomEt(String nom, String prenom);
    List<Etudiant> findEtudiantsByDateNaissanceAfter(LocalDate birthDate);
    List<Etudiant> findEtudiantByEcole(String schoolName);
//    List<Etudiant> findStudentsByReservationId(String reservationId);

}
