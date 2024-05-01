package org.ohara.maVraiDep.data.entitties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "classes")
public class Classe extends AbstractEntity {
    private String libelle;

    @OneToMany(mappedBy = "classe")
    List<Inscription> inscriptions;
    @ManyToOne
    private Filiere filiere;
    @ManyToOne
    private Niveau niveau;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<SessionCoursEtudiant> sessionCoursEtudiants;

    @OneToMany(mappedBy = "classe")
    private List<ClasseModule> classeModules;

    @OneToMany(mappedBy = "classe")
    List<SessionCoursClasse> sessionCoursClasses;

}
