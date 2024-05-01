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
@Data
@Builder
@Table(name = "salles")
public class Salle extends AbstractEntity{
    private String nom;
    private String number;
    private Integer nbrPlace;

    @OneToMany(mappedBy = "salle")
    private List<SessionCours> sessionCours;
}
