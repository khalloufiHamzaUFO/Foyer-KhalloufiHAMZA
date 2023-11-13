package tn.esprit.twin6.foyerkhalloufihamza.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.FoyerRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> addFoyers(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer editFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return foyerRepository.findById(id).orElse(Foyer.builder().idFoyer("io").nomFoyer("")
                .capaciteFoyer(0).build());
    }

    @Override
    public void deleteByIdF(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void delete(Foyer f) {
        foyerRepository.delete(f);
    }

    @Override
    public List<Foyer> findByBlocs(Bloc bloc) {
        return null;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).get();
        foyerRepository.save(foyer);
        u.setFoyer(foyer);
        universiteRepository.save(u);
        return foyer;
    }
}

