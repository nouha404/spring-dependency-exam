package org.ohara.maVraiDep.data.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ohara.maVraiDep.data.entitties.Classe;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasseRequestDto {
    private String libelle;
    public Classe TransformToEntity(){
        return Classe.builder()
                .libelle(libelle)
                .build();
    }
}
