package org.ohara.maVraiDep.data.web.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ohara.maVraiDep.data.entitties.Cours;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AngularCoursRequestDto {
    private Long id;

    @Positive(message = "Le nombre d'heures global doit être un entier positif supérieur à zéro")
    private long nbreHeureGlobal;

    @Positive(message = "Le semestre doit être un entier positif supérieur à zéro")
    private Long semestreId;

    @Positive(message = "Le module doit être un entier positif supérieur à zéro")
    private Long moduleId;

    @Positive(message = "Le professeur doit être un entier positif supérieur à zéro")
    private Long professeurId;

    public Cours TransformToEntity() {
        return Cours.builder()
                .nbreHeureGlobal(nbreHeureGlobal)
                .build();
    }


}
