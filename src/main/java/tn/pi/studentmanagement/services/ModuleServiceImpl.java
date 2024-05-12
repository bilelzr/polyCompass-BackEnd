package tn.pi.studentmanagement.services;


import org.springframework.stereotype.Service;
import tn.pi.studentmanagement.entities.Module;
import tn.pi.studentmanagement.repositories.ModuleRepository;
import tn.pi.studentmanagement.tools.dtos.DtoMapper;
import tn.pi.studentmanagement.tools.dtos.request.ModuleRequest;
import tn.pi.studentmanagement.tools.dtos.response.ModuleResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;


    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<ModuleResponse> getAllModules() {
        return DtoMapper.mapListModuleToDto(moduleRepository.findAll());
    }

    @Override
    public ModuleResponse getModuleByCode(String code) {
        Optional<Module> module = moduleRepository.findModuleByCode(code);
        return module.map(DtoMapper::mapModuleToDto).orElse(null);
    }

    @Override
    public ModuleResponse getModuleByLibelle(String libelle) {
        Optional<Module> module = moduleRepository.findModuleByLibelle(libelle);
        return module.map(DtoMapper::mapModuleToDto).orElse(null);
    }

    @Override
    public ModuleResponse createNewModule(ModuleRequest moduleRequest) {
        Module module = new Module();
        module.setCode(moduleRequest.getCode());
        module.setCredit(moduleRequest.getCredit());
        module.setCoefficient(moduleRequest.getCoefficient());
        module.setDescription(moduleRequest.getDescription());
        module.setLibelle(moduleRequest.getLibelle());
        moduleRepository.save(module);
        return DtoMapper.mapModuleToDto(module);
    }

    @Override
    public boolean deleteModule(String code) {
        Optional<Module> module = moduleRepository.findModuleByCode(code);
        if (module.isPresent()) {
            moduleRepository.delete(module.get());
            return true;
        }
        return false;
    }

    @Override
    public List<ModuleResponse> getListModuleByFormation(String uuidFormation) {
        return DtoMapper.mapListModuleToDto(moduleRepository.findModuleByFormation(UUID.fromString(uuidFormation)));
    }

    @Override
    public List<ModuleResponse> getListModuleByClass(String uuidClass) {
        return DtoMapper.mapListModuleToDto(moduleRepository.findModuleByClass(UUID.fromString(uuidClass)));
    }
}
