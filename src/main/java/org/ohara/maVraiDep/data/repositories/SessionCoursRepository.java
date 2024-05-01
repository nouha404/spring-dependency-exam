package org.ohara.maVraiDep.data.repositories;

import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SessionCoursRepository extends JpaRepository<SessionCours,Long> {
    Page<SessionCours> findAllByIsActiveTrueAndEtatSessionIsTrue(Pageable page);
    @Query("SELECT sc FROM SessionCours sc WHERE sc.cours.module.id = :moduleId")
    Page<SessionCours> findByModule(@Param("moduleId") String moduleId ,Pageable page);
    @Query(
            "SELECT sc FROM SessionCours sc " +
                    "JOIN sc.cours.professeur p " +
                    "JOIN sc.cours.module m " +
                    "WHERE p.id= :professorId" +
                    " AND m.libelle = :module " +
                    "AND MONTH(sc.date) = MONTH(CURRENT_DATE) " +
                    "AND YEAR(sc.date) = YEAR(CURRENT_DATE) " +
                    "AND sc.isActive = true"
    )
    Page<SessionCours> findByProfessorAndModule(Pageable pageable, @Param("professorId") Long professorId, @Param("module") String module);



    @Query(
            "SELECT sc FROM SessionCours sc " +
                    "JOIN sc.cours.professeur p " +
                    "WHERE p.id= :professorId" +
                    " AND MONTH(sc.date) = MONTH(CURRENT_DATE) " +
                    "AND YEAR(sc.date) = YEAR(CURRENT_DATE) " +
                    "AND sc.isActive = true"
    )
    Page<SessionCours> findByProfessorForCurrentMonth(Pageable page, @Param("professorId") Long professorId);

    @Query("SELECT sce.etudiant FROM SessionCoursEtudiant sce WHERE sce.sessionCours.id = :sessionId")
    Page<Etudiant> findByEtudiant(@Param("sessionId") Long sessionId, Pageable page);

}
