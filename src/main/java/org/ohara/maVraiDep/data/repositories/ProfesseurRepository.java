package org.ohara.maVraiDep.data.repositories;


import org.ohara.maVraiDep.data.entitties.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    List<Professeur> findAllByIsActiveTrue();
}
