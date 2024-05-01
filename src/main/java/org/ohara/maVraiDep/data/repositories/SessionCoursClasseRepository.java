package org.ohara.maVraiDep.data.repositories;

import org.ohara.maVraiDep.data.entitties.SessionCoursClasse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionCoursClasseRepository extends JpaRepository<SessionCoursClasse,Long> {
    List<SessionCoursClasse> findAllByIsActiveTrue();
}
