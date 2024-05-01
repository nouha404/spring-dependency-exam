package org.ohara.maVraiDep.data.web.dto.response;


import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.enums.ETypeSession;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class SessionCoursResponseDto {
    private Long id;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private ETypeSession typeSession;
    private String etatSession;
    private String cours;
    private String salle;

    private long nombreHeurePlanifier;


    private long professeurId;

    public  static SessionCoursResponseDto toDto(SessionCours sessionCours) {

        return SessionCoursResponseDto.builder()
                .id(sessionCours.getId())
                .date(sessionCours.getDate())
                .heureDebut(sessionCours.getHeureDebut())
                .heureFin(sessionCours.getHeureFin())
                .nombreHeurePlanifier(sessionCours.getNombreHeurePlanifier())
                .professeurId(sessionCours.getCours().getProfesseur().getId())
                .typeSession(sessionCours.getTypeSession())
                .etatSession(sessionCours.getEtatSession().name())
                .cours(sessionCours.getCours().getModule().getLibelle())
                .build();
    }
}
