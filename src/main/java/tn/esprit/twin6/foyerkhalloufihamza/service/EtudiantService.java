package tn.esprit.twin6.foyerkhalloufihamza.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Etudiant;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.EtudiantRepository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {
    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant editEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return etudiantRepository.findById(id).orElse(Etudiant.builder().idEtudiant(0).nomEt("")
                .prenomEt("").cin(0).ecole("").dateNaissance(LocalDate.now()).build());
    }

    @Override
    public void deleteByIdE(long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void delete(Etudiant e) {
        etudiantRepository.delete(e);
    }

    @Override
    public List<Etudiant> findEtudiantsByCin(long studentCIN) {
        return etudiantRepository.findEtudiantsByCin(studentCIN);
    }

    @Override
    public List<Etudiant> findEtudiantsByNomEtAndPrenomEt(String nom, String prenom) {
        return etudiantRepository.findEtudiantsByNomEtAndPrenomEt(nom,prenom);
    }

    @Override
    public List<Etudiant> findEtudiantsByDateNaissanceAfter(LocalDate birthDate) {
        return etudiantRepository.findEtudiantsByDateNaissanceAfter(birthDate);
    }

    @Override
    public List<Etudiant> findEtudiantByEcole(String schoolName) {
        return etudiantRepository.findEtudiantByEcole(schoolName);
    }

//    @Override
//    public List<Etudiant> findEtudiantByReservation(Reservation reservation) {
//        return etudiantRepository.findEtudiantByReservation(reservation);
//    }
}


