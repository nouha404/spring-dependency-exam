package org.ohara.maVraiDep.data.repositories;


import org.ohara.maVraiDep.data.entitties.AnneeScolaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire,Long> {
    AnneeScolaire findByIsActiveTrue();
}