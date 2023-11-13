package tn.esprit.twin6.foyerkhalloufihamza.DAO.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
@Entity
@Table(name="Bloc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bloc {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long idBloc ;
    @Column(name="nomBloc")
    private String nomBloc ;
    @Column(name="capaciteBloc")
    private int capaciteBloc ;
    @JsonIgnore
    @ManyToOne
    Foyer foyer ;

    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambers;
}