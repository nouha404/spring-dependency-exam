package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.Semestre;
import org.ohara.maVraiDep.data.repositories.SemestreRepository;
import org.ohara.maVraiDep.data.services.SemestreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SemestreServiceImpl implements SemestreService {
    private final SemestreRepository semestreRepository;
    @Override
    public List<Semestre> getSemestre() {
        return semestreRepository.findAllByIsActiveTrue();
    }
}
