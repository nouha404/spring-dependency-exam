package org.ohara.maVraiDep.data.web.dto.response;


import org.ohara.maVraiDep.data.entitties.Salle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class SalleSimpleResponseDto {
    private Long id;
    private String libelle;
    private Integer nbrPlace;

    public static SalleSimpleResponseDto toDto(Salle salle){
        return SalleSimpleResponseDto.builder()
                .id(salle.getId())
                .libelle(salle.getNom())
                .nbrPlace(salle.getNbrPlace())
                .build();
    }
}
