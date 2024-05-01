package org.ohara.maVraiDep.data.web.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ohara.maVraiDep.data.entitties.Module;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleRequestDto {
    private String libelle;
    public Module TransformToEntity(){
        return Module.builder()
                .libelle(libelle)
                .build();
    }
}
