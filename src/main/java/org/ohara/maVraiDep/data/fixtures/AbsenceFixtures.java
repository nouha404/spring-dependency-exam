package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.entitties.Absence;
import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.enums.StatusAbsence;
import org.ohara.maVraiDep.data.repositories.AbsenceRepository;
import org.ohara.maVraiDep.data.repositories.EtudiantRepository;
import org.ohara.maVraiDep.data.repositories.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Order(17) //17
@RequiredArgsConstructor
//@Component
public class AbsenceFixtures implements CommandLineRunner {
    private final AbsenceRepository absenceRepository;
    private final SessionCoursRepository sessionCoursRepository;
    private final EtudiantRepository etudiantRepository;
    @Override
    public void run(String... args) throws Exception {

        List<SessionCours> sessionCoursList = sessionCoursRepository.findAll();
        for (long i = 0L; i < sessionCoursList.size(); i++){
            SessionCours sessionCours = sessionCoursList.get((int) i);
            for (long j = 1L; j < 5L; j++) {
                Etudiant etudiant = etudiantRepository.findById(j).orElse(null);

                Absence absence = new Absence();
                absence.setDateAbsence(new Date());
                absence.setHeureAbsence(LocalTime.now());
                absence.setStatusAbsence(j%2==0? StatusAbsence.NON_JUSTIFIER : StatusAbsence.JUSTIFIER);

                absence.setEtudiant(etudiant);
                absence.setSessionCours(sessionCours);
                absence.setIsActive(true);
                absence.setMotif(j%2==0? "Maladie":"Retard");

                absenceRepository.save(absence);
            }


        }


    }
}