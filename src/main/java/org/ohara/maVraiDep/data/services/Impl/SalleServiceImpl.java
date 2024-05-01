package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.Salle;
import org.ohara.maVraiDep.data.repositories.SalleRepository;
import org.ohara.maVraiDep.data.services.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalleServiceImpl implements SalleService {
    private final SalleRepository salleRepository;
    @Override
    public List<Salle> getSalles() {
        return salleRepository.findAllByIsActiveTrue();
    }
}
