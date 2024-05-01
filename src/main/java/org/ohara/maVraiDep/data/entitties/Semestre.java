package org.ohara.maVraiDep.data.entitties;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "semestres")
public class Semestre extends AbstractEntity{
    private String libelle;
    @ManyToOne
    private Niveau niveau;
    @OneToMany(mappedBy = "semestre")
    List<Cours> cours;

}
