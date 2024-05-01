package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.Professeur;
import org.ohara.maVraiDep.data.repositories.ProfesseurRepository;
import org.ohara.maVraiDep.data.services.ProfesseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {
    private final ProfesseurRepository professeurRepository;
    @Override
    public List<Professeur> getProfesseur() {
        return professeurRepository.findAllByIsActiveTrue();
    }
}
