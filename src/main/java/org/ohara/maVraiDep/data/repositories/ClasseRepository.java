package org.ohara.maVraiDep.data.repositories;


import org.ohara.maVraiDep.data.entitties.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    List<Classe> findAllByIsActiveTrue();
}
