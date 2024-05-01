package org.ohara.maVraiDep.data.fixtures;

import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.ClasseModule;
import org.ohara.maVraiDep.data.entitties.Module;
import org.ohara.maVraiDep.data.repositories.ClasseModuleRepository;
import org.ohara.maVraiDep.data.repositories.ClasseRepository;
import org.ohara.maVraiDep.data.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(9)
@RequiredArgsConstructor
//@Component
public class ClasseModuleFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;
    private final ClasseModuleRepository classeModuleRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Classe> classeList = classeRepository.findAll();
        List<Module> moduleList = moduleRepository.findAll();
        for (long i = 0; i < classeList.size(); i++) {
            ClasseModule classeModule = new ClasseModule();

            Classe classe = classeList.get((int) i);


            classeModule.setClasse(classe);
            for (long j = 0; j <=moduleList.size() ; j++) {
                Module module = moduleRepository.findById(j).orElse(null);
                classeModule.setModule(module);

            }
            classeModule.setIsActive(true);

            classeModuleRepository.save(classeModule);

        }

    }
}
