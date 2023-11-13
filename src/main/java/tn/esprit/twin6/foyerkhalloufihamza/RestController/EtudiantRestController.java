package tn.esprit.twin6.foyerkhalloufihamza.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Etudiant;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;
import tn.esprit.twin6.foyerkhalloufihamza.service.IEtudiantService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@RestController
@AllArgsConstructor
public class EtudiantRestController {
    @Autowired
    IEtudiantService iEtudiantService;

    @GetMapping("findAllEtudiant")
    List<Etudiant> findAllE(){
        return iEtudiantService.findAll();
    }

    @PostMapping("/addEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.addEtudiant(e);
    }

    @DeleteMapping("/deleteEtudiant")
    public void delete(@RequestBody Etudiant e) {
        iEtudiantService.delete(e);
    }

    @DeleteMapping("/deleteByIdE/{id}")
    public void deleteByIdE(@PathVariable Long id) {
        iEtudiantService.deleteByIdE(id);
    }

    @PutMapping("/editEtudiant")
    public Etudiant editEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.editEtudiant(e);
    }

    @GetMapping("/findEtudiantsByCin")
    List<Etudiant> findEtudiantsByCin(@RequestParam("cin") long cin ){
        return iEtudiantService.findEtudiantsByCin(cin);
    }

    @GetMapping("/findEtudiantsByNomEtAndPrenomEt")
    List<Etudiant> findEtudiantsByNomEtAndPrenomEt(@RequestParam("nom") String nom,
                                                   @RequestParam("prenom") String pre){
        return iEtudiantService.findEtudiantsByNomEtAndPrenomEt(nom, pre);
    }

    @GetMapping("/findEtudiantsByDateNaissanceAfter")
    List<Etudiant> findEtudiantsByDateNaissanceAfter(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return iEtudiantService.findEtudiantsByDateNaissanceAfter( date);
    }

    @GetMapping("/findEtudiantByEcole")
    List<Etudiant> findEtudiantByEcole(@RequestParam("ecole") String str){
        return iEtudiantService.findEtudiantByEcole( str);
    }

//    @GetMapping("/findEtudiantByReservations")
//    List<Etudiant> findEtudiantByReservations(@RequestBody Reservation reservation){
//        return iEtudiantService.findEtudiantByReservation(Reservation.builder().idReservation(reservation.getIdReservation()).anneUniversitaire(reservation.getAnneUniversitaire()).estValide(reservation.isEstValide()).build());
//    }
}

