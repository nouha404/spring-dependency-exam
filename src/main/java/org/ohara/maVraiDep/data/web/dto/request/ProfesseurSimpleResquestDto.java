package org.ohara.maVraiDep.data.web.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ohara.maVraiDep.data.entitties.Professeur;
import org.ohara.maVraiDep.data.entitties.Semestre;
import org.ohara.maVraiDep.data.enums.ENiveau;
import org.ohara.maVraiDep.data.enums.Specialiter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurSimpleResquestDto {
    private String nom;
    private String prenom;
    @Enumerated(value = EnumType.STRING)
    private Specialiter specialite;
    private ENiveau grade;


    public Professeur TransformToEntity(){
        return Professeur.builder()
                .nom(nom)
                .prenom(prenom)
                .specialite(specialite)
                .grade(grade)
                .build();
    }

    public String nomComplet(){
        return prenom + " " + nom;
    }
}
