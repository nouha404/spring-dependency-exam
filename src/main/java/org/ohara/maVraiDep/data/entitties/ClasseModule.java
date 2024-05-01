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
@Table(name = "classe_module")
public class ClasseModule extends AbstractEntity {
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Module module;
}
