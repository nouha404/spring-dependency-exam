package org.ohara.maVraiDep.data.entitties;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessionCours_etudiant")
public class SessionCoursEtudiant extends AbstractEntity{
    @ManyToOne
    private SessionCours sessionCours;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Classe classe;
}
