package org.ohara.maVraiDep.data.web.dto.response;

import org.ohara.maVraiDep.data.entitties.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleSimpleResponseDto {
    private Long id;
    private String libelle;

    public static ModuleSimpleResponseDto toDto(Module module){
        return ModuleSimpleResponseDto.builder()
                .id(module.getId())
                .libelle(module.getLibelle())
                .build();
    }
}
