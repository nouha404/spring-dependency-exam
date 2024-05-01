package org.ohara.maVraiDep.data.fixtures;


import lombok.RequiredArgsConstructor;
import org.ohara.maVraiDep.data.configurations.FakerConfig;
import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.enums.ESexe;
import org.ohara.maVraiDep.data.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Order(6)
@RequiredArgsConstructor
//@Component
public class EtudiantFixtures implements CommandLineRunner {
    private final EtudiantRepository etudiantRepository;
    private final FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 10L; i++) {
            String nomComplet = fakerConfig.faker().name().fullName();
            String matricule = "MAT"+ fakerConfig.faker().numerify("######");

            Etudiant etudiant = new Etudiant();
            etudiant.setNomComplet(nomComplet);
            etudiant.setMatricule(matricule);
            etudiant.setSexe(i%2==0 ? ESexe.FEMININ : ESexe.MASCULIN);
            etudiant.setIsActive(true);
            Date birthday = fakerConfig.faker().date().birthday(18,29);
            Instant instant = birthday.toInstant();
            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
            etudiant.setDateNaissance(localDate);
            etudiantRepository.save(etudiant);

        }
    }
}