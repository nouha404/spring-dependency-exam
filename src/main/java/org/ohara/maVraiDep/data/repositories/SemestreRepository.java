package org.ohara.maVraiDep.data.repositories;

import org.ohara.maVraiDep.data.entitties.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {

    List<Semestre> findAllByIsActiveTrue();
}
