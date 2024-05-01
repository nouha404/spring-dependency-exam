package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.entitties.Niveau;
import org.ohara.maVraiDep.data.entitties.Semestre;
import org.ohara.maVraiDep.data.enums.ENiveau;
import org.ohara.maVraiDep.data.repositories.NiveauRepository;
import org.ohara.maVraiDep.data.repositories.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@RequiredArgsConstructor
//@Component
public class SemestreFixtures implements CommandLineRunner {
    private final SemestreRepository semestreRepository;
    private final NiveauRepository niveauRepository;
    @Override
    public void run(String... args) throws Exception {

        for (ENiveau libelle : ENiveau.values()) {
            Niveau niveau = niveauRepository.findById(libelle.getIndexEnumEtat()).orElse(null);
            for (int i = 1; i <= 2; i++) {
                Semestre semestre = new Semestre();
                semestre.setLibelle("Semestre " + i);
                semestre.setNiveau(niveau);
                semestre.setIsActive(true);
                semestreRepository.save(semestre);
            }
        }
    }
}