package tn.esprit.twin6.foyerkhalloufihamza.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Chambre;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.TypeChambre;
import tn.esprit.twin6.foyerkhalloufihamza.service.IChambreService;

import java.util.List;
@RestController
@RequestMapping("Chamber")
@AllArgsConstructor
public class ChambreRestController {
    IChambreService iChambreService;

    @GetMapping("/findAllChambre")
    List<Chambre> findAllC(){
        return iChambreService.findAll();
    }

    @PostMapping("/addChambre")
    Chambre addChambre(@RequestBody Chambre c){
        return iChambreService.addChambre(c);
    }

    @DeleteMapping("/deleteChambre")
    public void delete(@RequestBody Chambre c) {
        iChambreService.delete(c);
    }

    @DeleteMapping("/deleteByIdC/{id}")
    public void deleteById(@PathVariable Long id) {
        iChambreService.deleteByIdC(id);
    }

    @PutMapping("/editChambre")
    public Chambre editChambre(@RequestBody Chambre c) {
        return iChambreService.editChambre(c);
    }

    @GetMapping("/getChambreByTwo")
    public List<Chambre> getByTwo(  @RequestParam("numeroChambre") long numeroChambre,
                                    @RequestParam("typeC") TypeChambre typeC) {
        return iChambreService.findByNumeroChambreOrTypeC(numeroChambre,typeC);
    }

    @GetMapping("/findByNumeroChambre")
    public List<Chambre> findByNumeroChambre(  @RequestParam("numeroChambre") long numeroChambre) {
        return iChambreService.findByNumeroChambre(numeroChambre);
    }

    @GetMapping("/findByTypeC")
    public List<Chambre> findByTypeC(  @RequestParam("TypeChambre") TypeChambre t) {
        return iChambreService.findByTypeC(t);
    }

    @GetMapping("/findByBloc")
    public List<Chambre> findByBloc(  @RequestBody Bloc bloc) {
        return iChambreService.findByBloc(Bloc.builder().idBloc(bloc.getIdBloc()).nomBloc(bloc.getNomBloc()).chambers(bloc.getChambers()).build());
    }

    @GetMapping("/findChambresByBlocAndTypeC")
    public List<Chambre> findChambresByBlocAndTypeC(  @RequestBody Bloc bloc,@RequestParam("TypeChambre") TypeChambre t) {
        return iChambreService.findChambresByBlocAndTypeC(Bloc.builder().idBloc(bloc.getIdBloc()).nomBloc(bloc.getNomBloc()).chambers(bloc.getChambers()).build(),t);
    }




}
