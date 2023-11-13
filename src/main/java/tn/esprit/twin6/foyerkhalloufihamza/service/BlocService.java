package tn.esprit.twin6.foyerkhalloufihamza.service;

import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Chambre;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.BlocRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.ChambreRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.FoyerRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository ;



    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

//
//    @Override
//    public Bloc addBloc(Bloc b) {
//
//        Set<Chambre> chambers = b.getChambers();
//        Set<Long> chambreIds = chambers.stream().map(Chambre::getIdChamber).collect(Collectors.toSet());
//        for (long c : chambreIds){
//            chambreRepository.deleteById(c);
//        }
//        blocRepository.delete(b);
//    }


    @Override
    public List<Bloc> addBlocs(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

    @Override
    public Bloc editBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0).nomBloc("Pas de bloc").build());
    }

    @Override
    public void deleteById(long id) {
        blocRepository.deleteById(id);
    }

//    @Override
//    public void delete(Bloc b) {
//        blocRepository.delete(b);
//    }
    @Override
    public void delete(Bloc b) {
        Set<Chambre> chambers = b.getChambers();
        Set<Long> chambreIds = chambers.stream().map(Chambre::getIdChamber).collect(Collectors.toSet());
        for (long c : chambreIds){
            chambreRepository.deleteById(c);
        }
        blocRepository.delete(b);
    }

    @Override
    public List<Bloc> findBlocByNomBloc(String s) {
        return blocRepository.findBlocByNomBloc(s);
    }

    @Override
    public List<Bloc> findBlocByCapaciteBloc(long s) {
        return blocRepository.findBlocByCapaciteBloc(s);
    }

    @Override
    public List<Bloc> findBlocByNomBlocAndCapaciteBloc(String s, long l) {
        return blocRepository.findBlocByNomBlocAndCapaciteBloc(s,l);
    }

    @Override
    public List<Bloc> findBlocByNomBlocIgnoreCase(String s) {
        return blocRepository.findBlocByNomBlocIgnoreCase(s);
    }

    @Override
    public List<Bloc> findByCapaciteBlocGreaterThan(long l) {
        return blocRepository.findByCapaciteBlocGreaterThan(l);
    }

    @Override
    public List<Bloc> findByNomBlocContaining(String subString) {
        return blocRepository.findByNomBlocContaining(subString);
    }

    @Override
    public List<Bloc> findAllByOrderByNomBlocAsc() {
        return blocRepository.findAllByOrderByNomBlocAsc();
    }

    @Override
    public List<Bloc> findByNomBlocContainingOrCapaciteBloc(String nomBloc, long capaciteBloc) {
        return blocRepository.findByNomBlocContainingOrCapaciteBloc(nomBloc,capaciteBloc);
    }

    @Override
    public List<Bloc> findByFoyer(Foyer foyer) {
        return blocRepository.findByFoyer(foyer);
    }

    @Override
    public List<Bloc> findByFoyerUniversiteAndFoyerAndNomBloc(Universite universite, Foyer foyer, String nomBloc) {
        return blocRepository.findByFoyerUniversiteAndFoyerAndNomBloc(universite,foyer,nomBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) {
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        Set<Chambre> chambers = new HashSet<>();
        numChambre.forEach(numero ->{
            Chambre c = (Chambre) chambreRepository.findByNumerochamber(numero);
            c.setBloc(b);
            chambreRepository.save(c);
            chambers.add(c);
        });
        b.setChambers(chambers);
        return blocRepository.save(b);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Foyer f = foyerRepository.findFoyerByNomFoyer(nomFoyer);
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        b.setFoyer(f);
        return blocRepository.save(b);
    }
}




//
//    @Override
//    public Bloc findById(long id) {
////        return blocRepository.findById(id).get();
////        or
//        return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0).nomBloc("SS").build());
//    }