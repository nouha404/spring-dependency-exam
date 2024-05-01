package org.ohara.maVraiDep.data.services;

import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursEtudiant;
import org.ohara.maVraiDep.data.web.dto.request.SessionCoursRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SessionCoursService {
    Page<SessionCours> getSessionCours(String module,Long professeurId,Pageable page);
    Page<SessionCours> getSessionsByProfessorForCurrentMonth(Pageable pageable,Long professorId,String module);

    Page<Etudiant> getEtudiantByCours(Long etudiantId, Pageable page);
    void inValidateSessionCours(Long id,Long sessionId);
    void validateSessionCours(Long id,Long sessionId);

    void addSessionCours(SessionCoursRequestDto dto,Long coursId);
    Page<SessionCoursEtudiant> getEtudiantBySessionCours(Long sessionId,Pageable pageable);

    void tester(SessionCoursRequestDto dto);
}
