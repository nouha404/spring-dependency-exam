package org.ohara.maVraiDep.data.security.repositories;



import org.ohara.maVraiDep.data.security.data.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
