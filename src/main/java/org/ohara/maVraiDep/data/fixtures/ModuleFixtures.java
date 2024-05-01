package org.ohara.maVraiDep.data.fixtures;


import org.ohara.maVraiDep.data.entitties.Module;
import lombok.RequiredArgsConstructor;
import org.ohara.maVraiDep.data.configurations.FakerConfig;
import org.ohara.maVraiDep.data.repositories.ModuleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(8)
@RequiredArgsConstructor
//@Component
public class ModuleFixtures implements CommandLineRunner {
    private final ModuleRepository moduleRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 10L; i++) {
            Module module = new Module();
            module.setIsActive(true);
            module.setLibelle(fakerConfig.faker().educator().course());

            moduleRepository.save(module);

        }

    }
}