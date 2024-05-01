package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.SessionCoursClasse;
import org.ohara.maVraiDep.data.repositories.SessionCoursClasseRepository;

import org.ohara.maVraiDep.data.services.SessionCoursClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SessionCoursClasseServiceImpl implements SessionCoursClasseService {
    private final SessionCoursClasseRepository sessionCoursClasseRepository;
    @Override
    public List<SessionCoursClasse> getAllSessionCoursClasses() {
        return sessionCoursClasseRepository.findAllByIsActiveTrue();
    }
}
