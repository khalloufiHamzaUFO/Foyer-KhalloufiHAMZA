package tn.esprit.twin6.foyerkhalloufihamza.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Foyer;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Universite;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.FoyerRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {

    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public List<Universite> addUniversites(List<Universite> universites) {
        return universiteRepository.saveAll(universites);
    }

    @Override
    public Universite editUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findByIdU(long id) {
        return universiteRepository.findById(id).orElse(Universite.builder().idUniversite(0).nomUniversite("0")
                .adress("").build());
    }

    @Override
    public void deleteByIdU(long id) {
        universiteRepository.deleteById(id);

    }

    @Override
    public void delete(Universite u) {
        universiteRepository.delete(u);
    }

    @Override
    public Universite findUniversiteByNomUniversite(String s) {
        return universiteRepository.findUniversiteByNomUniversite(s);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer f = foyerRepository.findById(idFoyer).get();
        Universite u = universiteRepository.findUniversiteByNomUniversite(nomUniversite);
        u.setFoyer(f);
        universiteRepository.save(u);
        return u;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).get();
        u.setFoyer(null);
        universiteRepository.save(u);
        return u;
    }

}
