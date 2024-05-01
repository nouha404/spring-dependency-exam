package org.ohara.maVraiDep.data.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ohara.maVraiDep.data.entitties.Salle;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalleRequestDto {
    private String nom;
    private String number;
    private Integer nbrPlace;

    public Salle TransformToEntity(){
        return Salle.builder()
                .nom(nom)
                .number(number)
                .nbrPlace(nbrPlace)
                .build();
    }
}
