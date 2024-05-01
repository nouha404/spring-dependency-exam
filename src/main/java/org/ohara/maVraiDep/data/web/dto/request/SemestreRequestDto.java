package org.ohara.maVraiDep.data.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ohara.maVraiDep.data.entitties.Semestre;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreRequestDto {
    private String libelle;
    public Semestre TransformToEntity(){
        return Semestre.builder()
                .libelle(libelle)
                .build();
    }
}
