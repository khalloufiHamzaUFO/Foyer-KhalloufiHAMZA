package tn.esprit.twin6.foyerkhalloufihamza.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.service.IBlocService;

import java.util.List;

@AllArgsConstructor
@RestController
public class BlocController {
    IBlocService iBlocService;


    @GetMapping("/findAllBloc")
    List<Bloc> findAll() {
        return iBlocService.findAll();
    }

    @PostMapping("/addBloc")
    Bloc addBloc(@RequestBody Bloc b) {
        return iBlocService.addBloc(b);
    }

    @DeleteMapping("/deleteBloc")
    public void delete(@RequestBody Bloc b) {
        iBlocService.delete(b);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        iBlocService.deleteById(id);
    }

    @PutMapping("/editBloc")
    public Bloc editBloc(@RequestBody Bloc b) {
        return iBlocService.editBloc(b);
    }

    @GetMapping("/findAllByNomBlock")
    public List<Bloc> findAllByNomBloc(@RequestBody String s) {
        return iBlocService.findBlocByNomBloc(s);
    }

    @GetMapping("/findByCapaciteBlock")
    public List<Bloc> findBlocByCapaciteBloc(@RequestParam("capaciteBloc") long l) {
        return iBlocService.findBlocByCapaciteBloc(l);
    }

    @GetMapping("/findBlocByNomBlocAndCapaciteBloc")
    public List<Bloc> findBlocByNomBlocAndCapaciteBloc(@RequestParam("capaciteBloc") long l,
                                                       @RequestParam("nomBloc") String s) {
        return iBlocService.findBlocByNomBlocAndCapaciteBloc(s,l);
    }

    @GetMapping("/findBlocByNomBlocIgnoreCase")
    public List<Bloc> findBlocByNomBlocIgnoreCase(@RequestParam("nomBloc") String s) {
        return iBlocService.findBlocByNomBlocIgnoreCase(s);
    }

    @GetMapping("/findByCapaciteBlocGreaterThan")
    public List<Bloc> findByCapaciteBlocGreaterThan(@RequestParam("capaciteBloc") long l) {
        return iBlocService.findByCapaciteBlocGreaterThan(l);
    }

    @GetMapping("/findByNomBlocContaining")
    public List<Bloc> findByNomBlocContaining(@RequestParam("nomBloc") String s) {
        return iBlocService.findByNomBlocContaining(s);
    }


    @GetMapping("/findAllByOrderByNomBlocAsc")
    public List<Bloc> findAllByOrderByNomBlocAsc() {
        return iBlocService.findAllByOrderByNomBlocAsc();
    }


    @GetMapping("/findByNomBlocContainingOrCapaciteBloc")
    public List<Bloc> findByNomBlocContainingOrCapaciteBloc(
            @RequestParam("nomBloc") String nomBloc,
            @RequestParam("capaciteBloc") long capaciteBloc) {
        return iBlocService.findByNomBlocContainingOrCapaciteBloc(nomBloc, capaciteBloc);
    }

    @GetMapping("/findByFoyer")
    public List<Bloc> findByFoyer(@RequestBody Foyer foyer) {
        System.out.println(foyer.toString());
        return iBlocService.findByFoyer(foyer);
    }

    @PutMapping("affecterChamberAuBloc/{nomBloc}")
    Bloc affecterChambresAuBloc(@RequestBody List<Integer> numeros , @PathVariable("nomBloc") String nomBloc){
        return iBlocService.affecterChambresABloc(numeros , nomBloc);
    }
    @PutMapping("affecterBlocAuFoyer/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable("nomFoyer") String nomFoyer ,
                            @PathVariable("nomBloc") String nomBloc ){
        return iBlocService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }

//    @GetMapping("/findByFoyerUniversiteAndFoyerAndNomBloc")
//    public List<Bloc> findByFoyerUniversiteAndFoyerAndNomBloc(@RequestParam("nomBloc") String s) {
//        return iBlocService.findByFoyerUniversiteAndFoyerAndNomBloc(s);
//    }
//


}