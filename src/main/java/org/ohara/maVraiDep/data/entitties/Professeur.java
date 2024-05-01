package org.ohara.maVraiDep.data.entitties;



import org.ohara.maVraiDep.data.enums.ENiveau;
import org.ohara.maVraiDep.data.enums.Specialiter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "professeurs")
public class Professeur extends AbstractEntity {
    private String nom;
    private String prenom;
    @Enumerated(value = EnumType.STRING)
    private Specialiter specialite;
    private ENiveau grade;

    @OneToMany(mappedBy = "professeur")
    private List<Cours> cours;
    @OneToMany(mappedBy = "professeur")
    private List<ProfesseurClasse> professeurClasses;

}
