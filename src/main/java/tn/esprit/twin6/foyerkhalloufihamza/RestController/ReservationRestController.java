package tn.esprit.twin6.foyerkhalloufihamza.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Reservation;
import tn.esprit.twin6.foyerkhalloufihamza.service.IReservationService;

import java.util.List;
@RestController
@AllArgsConstructor
public class ReservationRestController {
    IReservationService iReservationService;


    @GetMapping("findAllRes")
    List<Reservation> findAllR(){
        return iReservationService.findAll();
    }

    @PostMapping("/addReservation")
    Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }

    @DeleteMapping("/deleteReservation")
    public void delete(@RequestBody Reservation r) {
        iReservationService.delete(r);
    }

    @DeleteMapping("/deleteByIdR/{id}")
    public void deleteByIdR(@PathVariable String id) {
        iReservationService.deleteByIdR("");
    }

    @PutMapping("/editReservation")
    public Reservation editReservation(@RequestBody Reservation r) {
        return iReservationService.editReservation(r);
    }

    @GetMapping("/findValidatedReservations")
    List<Reservation> findValidatedReservations(@RequestParam("valide") boolean b){
        return iReservationService.findReservationByEstValide(b);
    }

}