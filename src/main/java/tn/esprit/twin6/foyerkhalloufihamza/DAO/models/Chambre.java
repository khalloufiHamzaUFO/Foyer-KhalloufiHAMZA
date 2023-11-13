package tn.esprit.twin6.foyerkhalloufihamza.DAO.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="chamber")
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "idChamber")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChamber ;

    @Column(name="numeroChamber")
    private int numerochamber ;

    @Column(name="TypeC")
    private TypeChambre typeC ;

    @ManyToOne
    Bloc bloc ;

    @OneToMany(cascade =  CascadeType.ALL)
    private  Set<Reservation> res  ;
}