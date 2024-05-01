package org.ohara.maVraiDep.data.entitties;

import org.ohara.maVraiDep.data.enums.EtatCours;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "cours")
public class Cours extends AbstractEntity {
    private long nbreHeureGlobal;
    private long nombreHeurePlanifier;
    private LocalTime heuresEffectuees;
    private long heuresRestantes;
    private EtatCours etatCours;
    @ManyToOne
    private Semestre semestre;

    @ManyToOne
    private Module module;
    @OneToMany(mappedBy = "cours",cascade = CascadeType.ALL)
    private List<SessionCours> sessionCours;

    @ManyToOne
    private Professeur professeur;
    @ManyToOne
    private AnneeScolaire anneeScolaire;

}
