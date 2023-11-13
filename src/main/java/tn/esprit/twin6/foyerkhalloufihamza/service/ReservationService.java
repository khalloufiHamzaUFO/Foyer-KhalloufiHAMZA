package tn.esprit.twin6.foyerkhalloufihamza.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Chambre;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Etudiant;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.ChambreRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.EtudiantRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.ReservationRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ReservationService implements IReservationService {
    ReservationRepository reservationRepository;
    ChambreRepository chamberRepository ;
    EtudiantRepository etudiantRepository ;

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation editReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(String id) {
        return reservationRepository.findById(id).orElse(Reservation.builder().idReservation("")
                .anneeReservation(new Date()).estValide(true).build());
    }

    @Override
    public void deleteByIdR(String id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public void delete(Reservation r) {
        reservationRepository.delete(r);
    }

    @Override
    public List<Reservation> findReservationByEstValide(boolean b) {
        return reservationRepository.findReservationByEstValide(b);
    }


    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(int numChambre, long cin) {
        Chambre chambre = (Chambre) chamberRepository.findByNumerochamber(numChambre);
        Etudiant etudiant = (Etudiant) etudiantRepository.findEtudiantsByCin(cin);
        Set<Etudiant> etud = new HashSet<>( ) ;
        etud.add(etudiant);
        Reservation r = new Reservation();
        r.setIdReservation(etudiant.getNomEt()+"RES");
        r.setAnneeReservation(new Date());
        r.setEstValide(false);
        r.setEtudiants(etud);
        Set<Reservation> reservationsList = new HashSet<>();
        reservationsList.add(r);
        chambre.setRes(reservationsList);
        etudiant.setReservations(reservationsList);
        reservationRepository.save(r);
        etudiantRepository.save(etudiant);
        chamberRepository.save(chambre);
        return r;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e = (Etudiant) etudiantRepository.findEtudiantsByCin(cinEtudiant);

        return null;
    }




}
