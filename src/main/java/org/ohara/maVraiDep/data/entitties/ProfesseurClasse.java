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
@Table(name = "professeur_classe")
public class ProfesseurClasse  extends AbstractEntity{
    @ManyToOne
    private Professeur professeur;
    @ManyToOne
    private Classe classe;
}
