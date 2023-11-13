package tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Etudiant;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    List<Reservation> findReservationByEstValide(boolean b);

}
