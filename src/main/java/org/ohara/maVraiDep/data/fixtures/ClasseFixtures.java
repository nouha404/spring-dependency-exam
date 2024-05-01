package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.enums.EFiliere;
import org.ohara.maVraiDep.data.enums.ENiveau;
import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.Filiere;
import org.ohara.maVraiDep.data.entitties.Niveau;
import org.ohara.maVraiDep.data.repositories.ClasseRepository;
import org.ohara.maVraiDep.data.repositories.CoursRepository;
import org.ohara.maVraiDep.data.repositories.FiliereRepository;
import org.ohara.maVraiDep.data.repositories.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
@RequiredArgsConstructor
//@Component
public class ClasseFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final FiliereRepository filiereRepository;
    private final CoursRepository coursRepository;
    private final NiveauRepository niveauRepository;

    @Override
    public void run(String... args) throws Exception {
        for (ENiveau libelle : ENiveau.values()) {
            Niveau niveau = niveauRepository.findById(libelle.getIndexEnumEtat()).orElse(null);
            for (EFiliere filiere : EFiliere.values()) {
                Filiere fl = filiereRepository.findById(filiere.getIndexEnumEtat()).orElse(null);
                if (niveau != null && fl != null) {
                    Classe classe = new Classe();
                    classe.setLibelle(libelle.name() + filiere.name());
                    classe.setIsActive(true);
                    classe.setNiveau(niveau);
                    classe.setFiliere(fl);
                    classeRepository.save(classe);
                }
            }
        }


    }
}