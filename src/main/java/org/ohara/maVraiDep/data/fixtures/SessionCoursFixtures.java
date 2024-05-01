package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.enums.EEtatSession;
import org.ohara.maVraiDep.data.enums.ETypeSession;
import org.ohara.maVraiDep.data.entitties.Cours;
import org.ohara.maVraiDep.data.entitties.Salle;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.repositories.CoursRepository;
import org.ohara.maVraiDep.data.repositories.SalleRepository;
import org.ohara.maVraiDep.data.repositories.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Order(14) //14
@RequiredArgsConstructor
//@Component
public class SessionCoursFixtures implements CommandLineRunner {
    private final SessionCoursRepository sessionCoursRepository;
    private final CoursRepository coursRepository;
    private final SalleRepository salleRepository;

    @Override
    public void run(String... args) throws Exception {

        for (Long i = 1L; i < 5L; i++) {
            LocalTime heureDebut = LocalTime.parse("08:00:00");
            LocalTime heureFin = LocalTime.parse("17:00:00");
            ETypeSession typeSession = (i % 2 == 0 ? ETypeSession.PRESENTIEL : ETypeSession.EN_LIGNE);
            SessionCours sessionCours = new SessionCours();
            sessionCours.setDate(LocalDate.now());
            sessionCours.setIsActive(true);

            sessionCours.setHeureDebut(heureDebut);
            sessionCours.setHeureFin(heureFin);
            Duration duration = Duration.between(heureDebut, heureFin);
            long nombreHeure = duration.toHours();
            //sessionCours.setNombreHeurePlanifier(nombreHeure);

            sessionCours.setTypeSession(typeSession);
            sessionCours.setEtatSession(i%2==0? EEtatSession.VALIDER : EEtatSession.INVALIDER);

            Cours cours = coursRepository.findById(i).orElse(null);
            cours.setNbreHeureGlobal(i%2==0? 20:17);
            //sessionCours.setHeuresRestantes(ofSecondOfDay(cours.getNbreHeureGlobal()-nombreHeure));
            long heuresEffectuees = Duration.between(heureDebut, heureFin).toHours();
           // sessionCours.setHeuresEffectuees(LocalTime.ofSecondOfDay(heuresEffectuees));
            Salle salle = salleRepository.findById(i).orElse(null);
            sessionCours.setCours(cours);
            sessionCours.setSalle(salle);

            sessionCoursRepository.save(sessionCours);
        }

    }
}