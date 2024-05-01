package org.ohara.maVraiDep.data.web.dto.request;


import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursClasse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionCoursClasseRequestDto {
    private Long id;
    private Classe classe;
    private SessionCours sessionCours;


    public SessionCoursClasse TransformToEntity(){
        return SessionCoursClasse.builder()
                .classe(new Classe())
                .sessionCours(new SessionCours())
                .build();
    }
}
