package tn.esprit.twin6.foyerkhalloufihamza.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.service.IFoyerService;

import java.util.List;
@RestController
@AllArgsConstructor
public class FoyerRestController {

    IFoyerService iFoyerService;
    @GetMapping("findAllFoyer")
    List<Foyer> findAllF(){
        return iFoyerService.findAll();
    }

    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer f){
        return iFoyerService.addFoyer(f);
    }

    @DeleteMapping("/deleteFoyer")
    public void delete(@RequestBody Foyer f) {
        iFoyerService.delete(f);
    }

    @DeleteMapping("/deleteByIdF/{id}")
    public void deleteByIdF(@PathVariable Long id) {
        iFoyerService.deleteByIdF(id);
    }

    @PutMapping("/editFoyer")
    public Foyer editFoyer(@RequestBody Foyer f) {
        return iFoyerService.editFoyer(f);
    }
}