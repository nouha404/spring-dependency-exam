package org.ohara.maVraiDep.data.services.Impl;

import org.ohara.maVraiDep.data.entitties.Module;

import org.ohara.maVraiDep.data.repositories.ModulesRepository;
import org.ohara.maVraiDep.data.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModulesRepository moduleRepository;
    @Override
    public List<Module> getModules() {
        return moduleRepository.findAllByIsActiveTrue();
    }
}
