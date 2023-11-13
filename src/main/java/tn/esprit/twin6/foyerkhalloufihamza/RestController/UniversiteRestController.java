package tn.esprit.twin6.foyerkhalloufihamza.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;
import tn.esprit.twin6.foyerkhalloufihamza.service.IFoyerService;
import tn.esprit.twin6.foyerkhalloufihamza.service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteRestController {
    IUniversiteService iUniversiteService;
    IFoyerService iFoyerService;


    @GetMapping("findAllUniversities")
    List<Universite> findAllU(){
        return iUniversiteService.findAll();
    }

    @PostMapping("/addUniversite")
    Universite addUniversite(@RequestBody Universite u){
        return iUniversiteService.addUniversite(u);
    }

    @DeleteMapping("/deleteUniversite")
    public void delete(@RequestBody Universite u) {
        iUniversiteService.delete(u);
    }

    @DeleteMapping("/deleteByIdU/{id}")
    public void deleteByIdU(@PathVariable Long id) {
        iUniversiteService.deleteByIdU(id);
    }

    @PutMapping("/editUniversite")
    public Universite editUniversite(@RequestBody Universite u) {
        return iUniversiteService.editUniversite(u);
    }


//    @PostMapping("/affecterFoyerAUniversite")
//    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite){
//
//    }

    @PutMapping("/updateUniversite/{idFoyer}/{nomUniversite}")
    Universite affecterFoyerAuniversite(@PathVariable("idFoyer") long idFoyer ,
                                        @PathVariable("nomUniversite") String nomUniversite){
        return iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

    @PutMapping("desaffecterUniversite/{idUnive}")
    Universite descaffecterFoyer(@PathVariable("idUnive")long id){
        return iUniversiteService.desaffecterFoyerAUniversite(id);
    }



}
