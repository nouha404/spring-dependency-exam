package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.Professeur;
import org.ohara.maVraiDep.data.entitties.ProfesseurClasse;
import org.ohara.maVraiDep.data.repositories.ClasseRepository;
import org.ohara.maVraiDep.data.repositories.ProfesseurClasseRepository;
import org.ohara.maVraiDep.data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(11)
@RequiredArgsConstructor
//@Component
public class ProfesseurClasseFixtures implements CommandLineRunner {
    private final ProfesseurClasseRepository professeurClasseRepository;
    private final ProfesseurRepository professeurRepository;
    private final ClasseRepository classeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Classe> classeList = classeRepository.findAll();
        List<Professeur> professeurList = professeurRepository.findAll();

        for (long i = 0L; i < professeurList.size(); i++){
            Professeur professeur = professeurRepository.findById(i).orElse(null);
            ProfesseurClasse professeurClasse = new ProfesseurClasse();
            professeurClasse.setProfesseur(professeur);
            professeurClasse.setIsActive(true);

            for (long j = 0; j < classeList.size(); j++) {
                Classe classe = classeList.get((int) j);
                professeurClasse.setClasse(classe);

            }

            professeurClasseRepository.save(professeurClasse);
        }
    }
}
