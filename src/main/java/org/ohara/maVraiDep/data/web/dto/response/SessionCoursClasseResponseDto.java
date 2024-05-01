package org.ohara.maVraiDep.data.web.dto.response;


import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursClasse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class SessionCoursClasseResponseDto {
    private Long id;
    private Classe classe;
    private SessionCours sessionCours;

    public static SessionCoursClasseResponseDto toDto(SessionCoursClasse sessionCoursClasse) {
        return SessionCoursClasseResponseDto.builder()
                .id(sessionCoursClasse.getId())
                .classe(sessionCoursClasse.getClasse())
                .sessionCours(sessionCoursClasse.getSessionCours())
                .build();
    }
}
