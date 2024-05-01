package org.ohara.maVraiDep.data.repositories;


import org.ohara.maVraiDep.data.entitties.Cours;
import org.ohara.maVraiDep.data.entitties.Professeur;
import org.ohara.maVraiDep.data.enums.EtatCours;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    Page<Cours> findAllByEtatCoursAndIsActiveTrue(EtatCours etatCours, Pageable pageable);
    Page<Cours> findAllByIsActiveTrue(Pageable page);
    List<Cours> findAllByIsActiveTrue();
    Cours findByIdAndIsActiveTrue(Long id);
    Page<Cours> findByProfesseur(Professeur professeur, Pageable pageable);

    @Modifying
    @Query("UPDATE Cours c SET c.nombreHeurePlanifier = c.nombreHeurePlanifier + :heureToAdd WHERE c.id = :coursId")
    void addHeurePlanifier(@Param("coursId") Long coursId, @Param("heureToAdd") Long heureToAdd);

}
