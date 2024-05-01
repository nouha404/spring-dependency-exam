package org.ohara.maVraiDep.data.repositories;

import org.ohara.maVraiDep.data.entitties.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModulesRepository extends JpaRepository<Module,Long> {
    List<Module> findAllByIsActiveTrue();
}
