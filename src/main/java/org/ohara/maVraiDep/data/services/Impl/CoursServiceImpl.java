package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.AnneeScolaire;
import org.ohara.maVraiDep.data.entitties.Cours;
import org.ohara.maVraiDep.data.entitties.Module;
import org.ohara.maVraiDep.data.entitties.Professeur;
import org.ohara.maVraiDep.data.enums.EtatCours;
import org.ohara.maVraiDep.data.repositories.*;
import org.ohara.maVraiDep.data.services.CoursService;
import org.ohara.maVraiDep.data.web.dto.request.CoursRequestDto;
import org.ohara.maVraiDep.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;
    private final ModulesRepository modulesRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ProfesseurRepository professeurRepository;
    private final SemestreRepository semestreRepository;
    @Override
    public Page<Cours> getCours(String etatCours, Pageable page) {
        if (etatCours != null && !etatCours.isEmpty()) {
            return coursRepository.findAllByEtatCoursAndIsActiveTrue(EtatCours.valueOf(etatCours), page);
        } else {
            return coursRepository.findAllByIsActiveTrue(page);
        }
    }

    @Override
    public List<Cours> getCours() {
        return coursRepository.findAllByIsActiveTrue();
    }

    @Override
    public void addCours(CoursRequestDto dto) {
        Cours cours = dto.TransformToEntity();
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByIsActiveTrue();
        cours.setAnneeScolaire(anneeScolaire);
        cours.setModule(dto.TransformToEntity().getModule());
        cours.setSemestre(dto.TransformToEntity().getSemestre());
        cours.setProfesseur(dto.TransformToEntity().getProfesseur());
        cours.setIsActive(true);
        cours.setEtatCours(EtatCours.EN_COURS);
        cours.setNbreHeureGlobal(dto.getNbreHeureGlobal());

        coursRepository.save(cours);
    }

    @Override
    public List<Module> getModules() {
        return modulesRepository.findAll();
    }

    @Override
    public  Cours  getDetailsCours(Long id) {
        return coursRepository.findByIdAndIsActiveTrue(id);
    }

    @Override
    public Page<Cours> getCoursByProfesseur(Long id, Pageable page) {
        Professeur professeur = professeurRepository.findById(id).orElse(null);
        return coursRepository.findByProfesseur(professeur,page);
    }


}
