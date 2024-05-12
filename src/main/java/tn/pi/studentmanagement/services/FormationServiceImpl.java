package tn.pi.studentmanagement.services;

import org.springframework.stereotype.Service;
import tn.pi.studentmanagement.entities.Formation;
import tn.pi.studentmanagement.entities.Module;
import tn.pi.studentmanagement.repositories.FormationRepository;
import tn.pi.studentmanagement.repositories.ModuleRepository;
import tn.pi.studentmanagement.tools.dtos.DtoMapper;
import tn.pi.studentmanagement.tools.dtos.request.FormationRequest;
import tn.pi.studentmanagement.tools.dtos.response.FormationResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;

    private final ModuleRepository moduleRepository;

    public FormationServiceImpl(FormationRepository formationRepository, ModuleRepository moduleRepository) {
        this.formationRepository = formationRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public FormationResponse createFormation(FormationRequest formationRequest) {
        Formation formation = new Formation();
        formation.setDescription(formationRequest.getDescription());
        formation.setDuree(formationRequest.getDuree());
        formation.setLibelle(formationRequest.getLibelle());
        formation.setTagList(formationRequest.getTagList());
        formation.setUuid(UUID.randomUUID());
        //  formation.setModuleList(formationRequest.getModuleList());
        //   formation.setSemester(formationRequest.getSemester());
        formationRepository.saveAndFlush(formation);
        return DtoMapper.mapFormationToDto(formation);
    }

    @Override
    public List<FormationResponse> getAllFormation() {
        return DtoMapper.mapListFormationToDto(formationRepository.findAll());
    }

    @Override
    public FormationResponse getFormationByLibelle(String libelle) {
        Optional<Formation> formation = formationRepository.findFormationByLibelle(libelle);
        return formation.map(DtoMapper::mapFormationToDto).orElse(null);
    }

    @Override
    public boolean deleteFormation(String libelle) {
        Optional<Formation> formation = formationRepository.findFormationByLibelle(libelle);
        if (formation.isPresent()) {
            formationRepository.delete(formation.get());
            return true;
        }
        return false;
    }

    public FormationResponse getFormationByUiid(String uuid) {
        Optional<Formation> formation = formationRepository.findFormationByUuid(UUID.fromString(uuid));
        return formation.map(DtoMapper::mapFormationToDto).orElse(null);
    }

    @Override
    public FormationResponse addListModuleToFormation(List<String> codeModule, String uuidFormation) {
        Optional<Formation> formationOptional = formationRepository.findFormationByUuid(UUID.fromString(uuidFormation));
        if (formationOptional.isPresent()) {
            Formation formation = formationOptional.get();
            List<Module> modules = moduleRepository.findModuleByCodeInList(codeModule);
            formation.getModuleList().addAll(modules);
            formationRepository.save(formation);
            return DtoMapper.mapFormationToDto(formation);
        } else {
            return FormationResponse.builder().build();
        }
    }
}
