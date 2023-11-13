package tn.esprit.twin6.foyerkhalloufihamza.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Chambre;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.TypeChambre;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.BlocRepository;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService{

    ChambreRepository chambreRepository;
    BlocRepository blocRepository;

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> addChambres(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre editChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return chambreRepository.findById(id).orElse(Chambre.builder().idChamber(0).numerochamber(0)
                .typeC(TypeChambre.SIMPLE).build());
    }

    @Override
    public void deleteByIdC(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public void delete(Chambre c) {
        chambreRepository.delete(c);
    }

    @Override
    public List<Chambre> findByNumeroChambreOrTypeC(long num, TypeChambre type) {
        return chambreRepository.findByNumerochamberAndTypeC(num,type);
    }

    @Override
    public List<Chambre> findByNumeroChambre(long n) {
        return chambreRepository.findByNumerochamber(n);
    }

    @Override
    public List<Chambre> findByTypeC(TypeChambre t) {
        return chambreRepository.findByTypeC(t);

    }

    @Override
    public List<Chambre> findByNumeroChambreAndTypeC(long numeroChambre, TypeChambre type) {
        return chambreRepository.findByNumerochamberAndTypeC(numeroChambre, type);
    }

    @Override
    public List<Chambre> findByBloc(Bloc bloc) {
        return chambreRepository.findByBloc(bloc);
    }

    @Override
    public List<Chambre> findChambresByBlocAndTypeC(Bloc bloc, TypeChambre typeC) {
        return chambreRepository.findChambresByBlocAndTypeC(bloc, typeC);
    }


    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        return chambreRepository.findByBloc(b) ;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {
        return chambreRepository.findChamberByBlocFoyerNomFoyerAndTypeCAndReservations_Empty(nomFoyer,type);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return 0; // X
    }

}
