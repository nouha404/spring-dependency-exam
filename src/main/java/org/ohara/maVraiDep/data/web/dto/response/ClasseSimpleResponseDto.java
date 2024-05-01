package org.ohara.maVraiDep.data.web.dto.response;
import org.ohara.maVraiDep.data.entitties.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class ClasseSimpleResponseDto {
    private Long id;
    private String libelle;

    public static ClasseSimpleResponseDto toDto(Classe classe) {
        return ClasseSimpleResponseDto.builder()
                .id(classe.getId())
                .libelle(classe.getNiveau().getLibelle()+classe.getFiliere().getEFiliere().name())
                .build();
    }
}
