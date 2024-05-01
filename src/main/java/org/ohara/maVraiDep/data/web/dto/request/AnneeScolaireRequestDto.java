package org.ohara.maVraiDep.data.web.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ohara.maVraiDep.data.entitties.*;
import org.ohara.maVraiDep.data.entitties.Module;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnneeScolaireRequestDto {
    private Long id;
    private String libelle;
    private LocalDate finDePeriod;

    public  AnneeScolaire TransformToEntity(){
        return AnneeScolaire.builder()
                .libelle(libelle)
                .finDePeriod(finDePeriod)
                .build();
    }
}
