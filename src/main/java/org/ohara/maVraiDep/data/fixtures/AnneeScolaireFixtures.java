package org.ohara.maVraiDep.data.fixtures;


import org.ohara.maVraiDep.data.entitties.AnneeScolaire;
import org.ohara.maVraiDep.data.repositories.AnneeScolaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Order(5)
@RequiredArgsConstructor
//@Component
public class AnneeScolaireFixtures implements CommandLineRunner {
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int year = 2019; year <= 2025; year++) {
            LocalDate debutDePeriod = LocalDate.of(year, 9, 1);
            LocalDate finDePeriod = debutDePeriod.plusYears(1).minusDays(1);

            AnneeScolaire anneeScolaire = new AnneeScolaire();
            anneeScolaire.setIsActive(year == 2024);

            anneeScolaire.setLibelle(year + "-" + (year + 1));
            anneeScolaire.setFinDePeriod(finDePeriod);

            anneeScolaireRepository.save(anneeScolaire);
        }
    }

}