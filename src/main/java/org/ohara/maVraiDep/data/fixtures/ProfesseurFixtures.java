package org.ohara.maVraiDep.data.fixtures;


import lombok.RequiredArgsConstructor;
import org.ohara.maVraiDep.data.configurations.FakerConfig;
import org.ohara.maVraiDep.data.entitties.Professeur;
import org.ohara.maVraiDep.data.entitties.ProfesseurClasse;
import org.ohara.maVraiDep.data.enums.ENiveau;
import org.ohara.maVraiDep.data.enums.Specialiter;
import org.ohara.maVraiDep.data.repositories.ProfesseurClasseRepository;
import org.ohara.maVraiDep.data.repositories.ProfesseurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(10)
@RequiredArgsConstructor
//@Component
public class ProfesseurFixtures implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;
    private final ProfesseurClasseRepository professeurClasseRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 5L; i++) {
            List<ProfesseurClasse> professeurClasseList = professeurClasseRepository.findAll();
            Professeur professeur = new Professeur();

            professeur.setNom(fakerConfig.faker().name().firstName());
            professeur.setPrenom(fakerConfig.faker().name().lastName());
            professeur.setGrade(ENiveau.values()[(int) (i % ENiveau.values().length)]);
            professeur.setSpecialite(Specialiter.values()[(int) (i% Specialiter.values().length)]);
            professeur.setProfesseurClasses(professeurClasseList);
            professeur.setIsActive(true);
            professeurRepository.save(professeur);
        }
    }
}