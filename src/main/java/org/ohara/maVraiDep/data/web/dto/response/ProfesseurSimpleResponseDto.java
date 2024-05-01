package org.ohara.maVraiDep.data.web.dto.response;


import org.ohara.maVraiDep.data.entitties.Professeur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurSimpleResponseDto {
    private Long id;
    private String nomComplet;
    public static ProfesseurSimpleResponseDto toDto(Professeur professeur){
        return ProfesseurSimpleResponseDto.builder()
                .id(professeur.getId())
                .nomComplet(professeur.getPrenom()+" "+professeur.getNom())
                .build();
    }

}
