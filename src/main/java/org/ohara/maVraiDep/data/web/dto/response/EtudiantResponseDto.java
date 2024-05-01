package org.ohara.maVraiDep.data.web.dto.response;


import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.entitties.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.ohara.maVraiDep.data.entitties.SessionCoursEtudiant;
import org.ohara.maVraiDep.data.repositories.ClasseRepository;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class EtudiantResponseDto {
    private Long id;
    private String nomComplet;
    private String matricule;

    public  static EtudiantResponseDto toDto(Etudiant etudiant) {
        return EtudiantResponseDto.builder()
                .id(etudiant.getId())
                .nomComplet(etudiant.getNomComplet())
                .matricule(etudiant.getMatricule())
                .build();
    }

}
