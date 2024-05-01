package org.ohara.maVraiDep.data.security.data.fixtures;


import org.ohara.maVraiDep.data.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@RequiredArgsConstructor
@Order(2)
//@DependsOn("appRoleFixtures")
public class AppUserFixtures implements CommandLineRunner {
    private final SecurityService securityService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        securityService.saveUser("professeur10","nouha12b");
        securityService.addRoleToUser("professeur10","PROFESSEUR");

        securityService.saveUser("attache10","nouha12b");
        securityService.addRoleToUser("attache10","ATTACHE");

        securityService.saveUser("etudiant10","nouha12b");
        securityService.addRoleToUser("etudiant10","ETUDIANT");
    }
}
