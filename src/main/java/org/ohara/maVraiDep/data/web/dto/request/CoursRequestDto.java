package org.ohara.maVraiDep.data.web.dto.request;



import org.ohara.maVraiDep.data.entitties.AnneeScolaire;
import org.ohara.maVraiDep.data.entitties.Cours;
import org.ohara.maVraiDep.data.entitties.Module;
import org.ohara.maVraiDep.data.entitties.Professeur;
import org.ohara.maVraiDep.data.entitties.Semestre;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursRequestDto {
    private Long id;
    @Positive(message = "Le nombre d'heures global doit être un entier positif supérieur à zéro")
    private long nbreHeureGlobal;
    private Semestre semestre;
    private Module module;
    private Professeur professeur;
    private AnneeScolaire anneeScolaire;
    public Cours TransformToEntity(){
        return Cours.builder()
                .nbreHeureGlobal(nbreHeureGlobal)
                .anneeScolaire(anneeScolaire)
                .semestre(semestre)
                .module(module)
                .professeur(professeur)
                .build();

    }
}
