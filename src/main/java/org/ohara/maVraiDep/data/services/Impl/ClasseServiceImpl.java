package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.Classe;
import org.ohara.maVraiDep.data.repositories.ClasseRepository;
import org.ohara.maVraiDep.data.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;
    @Override
    public List<Classe> getClasses() {
        return classeRepository.findAllByIsActiveTrue();
    }
}
