package org.ohara.maVraiDep.data.repositories;

import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursEtudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionCoursEtudiantRepository extends JpaRepository<SessionCoursEtudiant,Long> {
    Page<SessionCoursEtudiant> findSessionCoursEtudiantsByEtudiantAndIsActiveTrue(Long sessionId, Pageable page);
    Page<SessionCoursEtudiant> findBySessionCours(SessionCours sessionCours,Pageable pageable);
}
