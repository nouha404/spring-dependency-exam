package org.ohara.maVraiDep.data.entitties;

import org.ohara.maVraiDep.data.enums.EEtatSession;
import org.ohara.maVraiDep.data.enums.ETypeSession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "sessionCours")
public class SessionCours extends AbstractEntity {
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private long nombreHeurePlanifier;
    private ETypeSession typeSession;
    private EEtatSession etatSession;

    @OneToMany(mappedBy = "sessionCours", cascade = CascadeType.ALL)
    private List<SessionCoursClasse> sessionCoursClasses;

    @OneToMany(mappedBy = "sessionCours", cascade = CascadeType.ALL)
    List<Absence> absences;

    @ManyToOne
    Cours cours;
    @ManyToOne
    Salle salle;
    @OneToMany(mappedBy = "sessionCours", cascade = CascadeType.ALL)
    private List<SessionCoursEtudiant> sessionCoursEtudiants;


}
