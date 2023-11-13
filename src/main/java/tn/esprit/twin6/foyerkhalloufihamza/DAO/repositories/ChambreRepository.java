package tn.esprit.twin6.foyerkhalloufihamza.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Bloc;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.Chambre;
import tn.esprit.twin6.foyerkhalloufihamza.DAO.models.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByNumerochamberOrTypeC(long num, TypeChambre type);
    List<Chambre> findByNumerochamber(long n);
    List<Chambre> findByTypeC(TypeChambre t);
    List<Chambre> findByNumerochamberAndTypeC(long numeroChambre, TypeChambre type);
    List<Chambre> findByBloc(Bloc bloc);
    List<Chambre> findChambresByBlocAndTypeC( Bloc bloc, TypeChambre typeC);
    //pathVariable
    //    @Query("SELECT C FROM Chambre C where C.numeroChambre=?1")
    //RequestParam
    // jpql oriente objet, mapped by 'equipes'

    //sql avec les tables
    @Query(value ="SELECT * FROM chambre  where numero_chamber=?1",nativeQuery = true)
    List<Chambre> selectByNumSQL(long num);

    List<Chambre> findChamberByBlocFoyerNomFoyerAndTypeCAndReservations_Empty(String NomFoyer , TypeChambre type);

    // Recherche par numéro de chamber
    @Query("select c from Chambre c where c.numerochamber=?1")
    List<Chambre> selectByNum(long num);

    @Query("select c from Chambre c where c.numerochamber=:num")
    List<Chambre> selectByNum2(@Param(value="num") long num)  ;

}
//2- Recherche par type de chambre
