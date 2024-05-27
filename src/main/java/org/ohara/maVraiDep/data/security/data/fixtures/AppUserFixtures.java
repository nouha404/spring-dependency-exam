package org.ohara.maVraiDep.data.security.data.fixtures;


import lombok.RequiredArgsConstructor;
import org.ohara.maVraiDep.data.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(2)
public class AppUserFixtures implements CommandLineRunner {
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {

        securityService.saveUser("rp","nouha12b");
        securityService.addRoleToUser("rp","RP");

        securityService.saveUser("professeur","nouha12b");
        securityService.addRoleToUser("professeur","PROFESSEUR");
    }
}
