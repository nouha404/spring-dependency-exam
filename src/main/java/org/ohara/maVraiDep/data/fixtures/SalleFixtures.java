package org.ohara.maVraiDep.data.fixtures;


import org.ohara.maVraiDep.data.configurations.FakerConfig;
import org.ohara.maVraiDep.data.entitties.Salle;
import org.ohara.maVraiDep.data.repositories.SalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(13) //13
@RequiredArgsConstructor
//@Component
public class SalleFixtures implements CommandLineRunner {
    private final SalleRepository salleRepository;
    private final FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 5L; i++) {
            Salle salle = new Salle();
            salle.setNom("Salle "+i);
            salle.setNumber(fakerConfig.faker().numerify("###"));
            salle.setNbrPlace(fakerConfig.faker().number().numberBetween(20, 41));
            salle.setIsActive(true);

            salleRepository.save(salle);

        }

    }
}