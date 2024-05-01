package org.ohara.maVraiDep.data.web.dto.request;


import org.ohara.maVraiDep.data.entitties.Cours;
import org.ohara.maVraiDep.data.entitties.Salle;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursClasse;
import org.ohara.maVraiDep.data.enums.EEtatSession;
import org.ohara.maVraiDep.data.enums.ETypeSession;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionCoursRequestDto {
    private Long id;
    @NotNull(message = "La date ne peut pas être nulle")
    @Future(message = "La date doit être dans le futur")
    private LocalDate date;
    @NotNull(message = "L'heure de début ne peut pas être nulle")
    private LocalTime heureDebut;
    @NotNull(message = "L'heure de fin ne peut pas être nulle")
    private LocalTime heureFin;
    private ETypeSession typeSession;
    private EEtatSession etatSession;

    private Cours cours;
    private Salle salle;
    private List<SessionCoursClasse> sessionCoursClasses;
    public SessionCours TransformToEntity(){

        return SessionCours.builder()
                .date(date)
                .heureDebut(heureDebut)
                .heureFin(heureFin)
                .cours(new Cours())
                .date(date)
                .etatSession(EEtatSession.INVALIDER)
                .sessionCoursClasses(sessionCoursClasses)
                .typeSession(typeSession)
                .salle(salle)
                .build();
    }
}
