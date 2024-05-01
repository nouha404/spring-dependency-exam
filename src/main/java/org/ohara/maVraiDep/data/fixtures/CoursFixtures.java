package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.entitties.*;
import org.ohara.maVraiDep.data.entitties.Module;
import org.ohara.maVraiDep.data.repositories.*;

import org.ohara.maVraiDep.data.enums.EtatCours;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Order(12) //12
@RequiredArgsConstructor
//@Component
public class CoursFixtures implements CommandLineRunner {
    private final CoursRepository coursRepository;
    private final SemestreRepository semestreRepository;
    private final ClasseRepository classeRepository;
    private final ProfesseurRepository professeurRepository;
    private final ModuleRepository moduleRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    @Override
    public void run(String... args) throws Exception {

        List<Classe> classeList = classeRepository.findAll();
        List<Semestre> semestres = semestreRepository.findAll();
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByIsActiveTrue();
        for (Semestre semestre : semestres) {
            for (Long i = 1L; i < 7L; i++) {
                Professeur professeur = professeurRepository.findById(i).orElse(null);
                Module module = moduleRepository.findById(i).orElse(null);

                Cours cours = new Cours();
                cours.setHeuresEffectuees(LocalTime.ofSecondOfDay(4));

                cours.setNbreHeureGlobal(20);
                cours.setHeuresRestantes(cours.getNbreHeureGlobal());
                cours.setEtatCours(i%2==0 ? EtatCours.TERMINER: EtatCours.EN_COURS);
                cours.setIsActive(true);
                cours.setAnneeScolaire(anneeScolaire);

                cours.setModule(module);
                cours.setSemestre(semestre);
                cours.setProfesseur(professeur);


                coursRepository.save(cours);
            }
        }

    }
}