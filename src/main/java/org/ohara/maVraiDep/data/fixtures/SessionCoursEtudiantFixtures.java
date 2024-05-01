package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursEtudiant;
import org.ohara.maVraiDep.data.repositories.ClasseRepository;
import org.ohara.maVraiDep.data.repositories.EtudiantRepository;
import org.ohara.maVraiDep.data.repositories.SessionCoursEtudiantRepository;
import org.ohara.maVraiDep.data.repositories.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Order(16) //16
@RequiredArgsConstructor
//@Component
public class SessionCoursEtudiantFixtures implements CommandLineRunner {
    private final SessionCoursRepository sessionCoursRepository;
    private final EtudiantRepository etudiantRepository;
    private final SessionCoursEtudiantRepository sessionCoursEtudiantRepository;
    private final ClasseRepository classeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Etudiant> etudiantList = etudiantRepository.findAll();
        List<SessionCours> sessionCoursList = sessionCoursRepository.findAll();
        List<Classe> classeList = classeRepository.findAll();

        for (SessionCours sessionCours : sessionCoursList) {
            for (Etudiant etudiant : etudiantList) {
                SessionCoursEtudiant sessionCoursEtudiant = new SessionCoursEtudiant();
                sessionCoursEtudiant.setIsActive(true);
                sessionCoursEtudiant.setEtudiant(etudiant);
                sessionCoursEtudiant.setSessionCours(sessionCours);

                Classe randomClasse = getRandomClasse(classeList);
                sessionCoursEtudiant.setClasse(randomClasse);

                sessionCoursEtudiantRepository.save(sessionCoursEtudiant);
            }
        }

    }

    private Classe getRandomClasse(List<Classe> classeList) {
        Random random = new Random();
        int randomIndex = random.nextInt(classeList.size());
        return classeList.get(randomIndex);
    }

}
