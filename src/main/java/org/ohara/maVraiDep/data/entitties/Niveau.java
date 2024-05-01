package org.ohara.maVraiDep.data.entitties;


import org.ohara.maVraiDep.data.enums.ENiveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "niveaux")
public class Niveau extends AbstractEntity{
    @Enumerated(value = EnumType.STRING)
    private ENiveau libelle;
    @OneToMany(mappedBy = "niveau")
    List<Semestre> semestres;
    @OneToMany(mappedBy = "niveau")
    List<Classe> classes;

}
