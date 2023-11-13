package tn.esprit.twin6.foyerkhalloufihamza.service;


import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Etudiant;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation r);
    List<Reservation> addReservations(List<Reservation> reservations);
    Reservation editReservation(Reservation r);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteByIdR(String id);

    void delete(Reservation r);
    List<Reservation> findReservationByEstValide(boolean b);
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(int numChambre, long cin);
    Reservation annulerReservation(long cinEtudiant);


}
