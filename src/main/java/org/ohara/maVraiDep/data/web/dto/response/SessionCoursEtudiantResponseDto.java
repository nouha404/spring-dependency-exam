package org.ohara.maVraiDep.data.web.dto.response;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursEtudiant;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class SessionCoursEtudiantResponseDto {
    private Long id;
    private String nomComplet;
    private String matricule;
    private String classe;

    public  static SessionCoursEtudiantResponseDto toDto(SessionCoursEtudiant sessionCoursEtudiant) {
        return SessionCoursEtudiantResponseDto.builder()
                .id(sessionCoursEtudiant.getId())
                .nomComplet(sessionCoursEtudiant.getEtudiant().getNomComplet())
                .classe(sessionCoursEtudiant.getClasse().getLibelle())
                .matricule(sessionCoursEtudiant.getEtudiant().getMatricule())
                .build();
    }

}
