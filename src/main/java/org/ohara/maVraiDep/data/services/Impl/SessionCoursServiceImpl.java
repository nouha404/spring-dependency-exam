package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.Cours;
import org.ohara.maVraiDep.data.entitties.Etudiant;
import org.ohara.maVraiDep.data.entitties.SessionCours;
import org.ohara.maVraiDep.data.entitties.SessionCoursEtudiant;
import org.ohara.maVraiDep.data.enums.EEtatSession;
import org.ohara.maVraiDep.data.enums.ETypeSession;
import org.ohara.maVraiDep.data.exceptions.EntityNotFoundException;
import org.ohara.maVraiDep.data.repositories.CoursRepository;
import org.ohara.maVraiDep.data.repositories.SalleRepository;
import org.ohara.maVraiDep.data.repositories.SessionCoursEtudiantRepository;
import org.ohara.maVraiDep.data.repositories.SessionCoursRepository;
import org.ohara.maVraiDep.data.services.SessionCoursService;
import org.ohara.maVraiDep.data.web.dto.request.SessionCoursRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class SessionCoursServiceImpl implements SessionCoursService {
    private final SessionCoursRepository sessionCoursRepository;
    private final SalleRepository salleRepository;
    private final SessionCoursEtudiantRepository sessionCoursEtudiantRepository;
    private final CoursRepository coursRepository;
    private String module;
    private Long professeurId;
    private Pageable page;


    @Override
    public Page<SessionCours> getSessionCours(String module, Long professeurId, Pageable page) {
        this.module = module;
        this.professeurId = professeurId;
        this.page = page;
        if (module != null && !module.isEmpty()) {
            return sessionCoursRepository.findByModule(module,page);
        } else if (module != null && !module.isEmpty() && professeurId != null) {
            return sessionCoursRepository.findByProfessorAndModule(page, professeurId, module);

        } else if (professeurId != null) {
            return sessionCoursRepository.findByProfessorForCurrentMonth(page, professeurId);
        }
        else {
            return sessionCoursRepository.findAllByIsActiveTrueAndEtatSessionIsTrue(page);
        }
    }

    @Override
    public Page<SessionCours> getSessionsByProfessorForCurrentMonth(Pageable pageable, Long professorId, String module) {
        if (module != null && !module.isEmpty()) {
            return sessionCoursRepository.findByProfessorAndModule(pageable, professorId, module);
        } else {
            return sessionCoursRepository.findByProfessorForCurrentMonth(pageable,professorId);
        }
    }

    @Override
    public Page<Etudiant> getEtudiantByCours(Long sessionId, Pageable page) {
        return sessionCoursRepository.findByEtudiant(sessionId,page);
    }

    @Transactional
    @Override
    public void inValidateSessionCours(Long id, Long sessionId) {
        SessionCours sessionCours = sessionCoursRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session de cours non trouvée avec l'ID : " + sessionId));

        sessionCours.setEtatSession(EEtatSession.INVALIDER);

        Cours cours = sessionCours.getCours();
        //cours.setHeuresRestantes(sessionCours.getNombreHeurePlanifier()+cours.getHeuresRestantes());
        cours.setNombreHeurePlanifier(0L);

        long heureRestant = sessionCours.getNombreHeurePlanifier()+cours.getHeuresRestantes();
        cours.setHeuresRestantes(heureRestant);
        sessionCours.setNombreHeurePlanifier(0L);
        sessionCours.setIsActive(false);
        sessionCoursRepository.save(sessionCours);

        coursRepository.save(cours);

    }

    @Override
    public void validateSessionCours(Long id, Long sessionId) {
        SessionCours sessionCours = sessionCoursRepository.findById(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Le SessionCours n'existe pas"));

        Cours cours = sessionCours.getCours();

        /*long nombreHeurePlanifier = calculateHeurePlanifier(sessionCours.getHeureDebut(), sessionCours.getHeureFin());
        long nombreHeureEffectuer = nombreHeurePlanifier;
        long heuresRestantes = cours.getNbreHeureGlobal() - nombreHeurePlanifier;*/
        long nombreHeure = calculateHeurePlanifier(sessionCours.getHeureDebut(), sessionCours.getHeureFin());
        long heuresPlanifieesTotales = cours.getNombreHeurePlanifier() + nombreHeure;
        long heuresRestantes = cours.getNbreHeureGlobal() - heuresPlanifieesTotales;

        //maj
        /*cours.setNombreHeurePlanifier(nombreHeurePlanifier);
        cours.setHeuresRestantes(heuresRestantes);
        cours.setHeuresEffectuees(LocalTime.ofSecondOfDay(nombreHeureEffectuer * 3600));*/

        cours.setHeuresEffectuees(LocalTime.ofSecondOfDay((int) (heuresPlanifieesTotales * 3600)));
        cours.setNombreHeurePlanifier(nombreHeure);
        cours.setHeuresRestantes(heuresRestantes);

        if (heuresPlanifieesTotales == cours.getNbreHeureGlobal()) {
            sessionCours.setEtatSession(EEtatSession.VALIDER);
            sessionCours.setIsActive(false);
        }

        coursRepository.save(cours);
        sessionCoursRepository.save(sessionCours);
    }

    @Transactional
    @Override
    public void addSessionCours(SessionCoursRequestDto dto, Long coursId) {
        SessionCours sessionCours = dto.TransformToEntity();
        sessionCours.setTypeSession(ETypeSession.PRESENTIEL);
        sessionCours.setEtatSession(EEtatSession.INVALIDER);
        sessionCours.setIsActive(true);
        sessionCours.setSalle(null);

        LocalTime heureDebut = dto.getHeureDebut();
        LocalTime heureFin = dto.getHeureFin();
        sessionCours.setDate(dto.getDate());
        sessionCours.setHeureDebut(heureDebut);
        sessionCours.setHeureFin(heureFin);

        Cours cours = coursRepository.findByIdAndIsActiveTrue(coursId);

        long nombreHeure = calculateHeurePlanifier(heureDebut, heureFin);
        /*long heuresPlanifieesTotales = cours.getNombreHeurePlanifier() + nombreHeure;
        long heuresRestantes = cours.getNbreHeureGlobal() - heuresPlanifieesTotales;*/


        //test
        if (ETypeSession.PRESENTIEL == sessionCours.getTypeSession()) {
            sessionCours.setSalle(dto.getSalle());
        } else {
            sessionCours.setSalle(null);
            sessionCours.setTypeSession(ETypeSession.PRESENTIEL);
        }

        sessionCours.setCours(cours);

        sessionCours.setNombreHeurePlanifier(nombreHeure);


        /*cours.setHeuresEffectuees(LocalTime.ofSecondOfDay((int) (heuresPlanifieesTotales * 3600)));
        cours.setNombreHeurePlanifier(nombreHeure);
        cours.setHeuresRestantes(heuresRestantes);*/

        sessionCoursRepository.save(sessionCours);
        //coursRepository.save(cours);


    }


    private long calculateHeurePlanifier(LocalTime heureDebut, LocalTime heureFin) {
        Duration duration = Duration.between(heureDebut, heureFin);
        return duration.toHours();
    }


    @Override
    public Page<SessionCoursEtudiant> getEtudiantBySessionCours(Long sessionId, Pageable pageable) {
        SessionCours sessionCours = sessionCoursRepository.findById(sessionId).orElseThrow(()->new EntityNotFoundException("Le SessionCours n'existe pas"));
        System.out.println(sessionCours);
        return sessionCoursEtudiantRepository.findBySessionCours(sessionCours,pageable);
    }

    @Override
    public void tester(SessionCoursRequestDto dto) {
        SessionCours sessionCours = dto.TransformToEntity();
        sessionCours.setDate(dto.getDate());
        sessionCours.setIsActive(true);
        sessionCours.setHeureDebut(dto.getHeureDebut());
        sessionCours.setHeureFin(dto.getHeureFin());

        /*Quand il n'insere pas il reste ici
        SessionCoursRequestDto(id=null, date=null, heureDebut=10:00, heureFin=12:00, typeSession=null,
        etatSession=null, cours=Cours(nbreHeureGlobal=0, nombreHeurePlanifier=0, heuresEffectuees=null, heuresRestantes=0, etatCours=null, semestre=null, module=null, sessionCours=null, professeur=null, anneeScolaire=null), salle=null, sessionCoursClasses=[])*/

        LocalTime heureDebut = dto.getHeureDebut();
        LocalTime heureFin = dto.getHeureFin();
        Duration duration = Duration.between(heureDebut, heureFin);
        long nombreHeure = duration.toHours();
        //sessionCours.setNombreHeurePlanifier(nombreHeure);
        sessionCours.setTypeSession(ETypeSession.PRESENTIEL); //pour linstant
        sessionCours.setEtatSession(EEtatSession.INVALIDER);

        Cours cours = coursRepository.findById(dto.getCours().getId()).orElse(null);
        sessionCours.setCours(cours);

        long heuresEffectuees = calculateHeurePlanifier(heureDebut, heureFin);
        long heuresRestantes = dto.getCours().getNbreHeureGlobal() - heuresEffectuees;

       /* sessionCours.setHeuresRestantes(LocalTime.ofSecondOfDay(heuresRestantes));
        sessionCours.setHeuresEffectuees(LocalTime.ofSecondOfDay(heuresEffectuees));
        sessionCours.setSalle(null);*/

        sessionCoursRepository.save(sessionCours);


    }

}
