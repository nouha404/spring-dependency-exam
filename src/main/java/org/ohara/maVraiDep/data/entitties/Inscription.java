package org.ohara.maVraiDep.data.entitties;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "inscriptions")
public class Inscription  extends AbstractEntity{
    @ManyToOne
    private AnneeScolaire anneeScolaire;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    Etudiant etudiant;
}
