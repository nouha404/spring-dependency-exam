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
@Table(name = "modules")
public class Module extends AbstractEntity {
    private String libelle;

    @OneToMany(mappedBy = "module")
    List<Cours> cours;
}
