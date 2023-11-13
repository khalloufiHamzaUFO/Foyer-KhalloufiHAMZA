package tn.esprit.twin6.foyerkhalloufihamza.DAO.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Reservation {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idReservation;

    @Column(name="anneeReservation")
    private Date anneeReservation ;

    @Column(name="estValide")
    private Boolean estValide ;

    @ManyToMany(cascade = CascadeType.ALL)
    public Set<Etudiant> etudiants ;
}

