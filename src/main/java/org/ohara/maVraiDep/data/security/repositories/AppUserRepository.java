package org.ohara.maVraiDep.data.security.repositories;



import org.ohara.maVraiDep.data.security.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
