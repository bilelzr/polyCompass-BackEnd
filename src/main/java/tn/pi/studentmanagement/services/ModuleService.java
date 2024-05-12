package tn.pi.studentmanagement.services;

import tn.pi.studentmanagement.tools.dtos.request.ModuleRequest;
import tn.pi.studentmanagement.tools.dtos.response.ModuleResponse;

import java.util.List;

public interface ModuleService {


    public List<ModuleResponse> getAllModules();

    public ModuleResponse getModuleByCode(String code);

    public ModuleResponse getModuleByLibelle(String libelle);

    public ModuleResponse createNewModule(ModuleRequest moduleRequest);

    boolean deleteModule(String code);

    public List<ModuleResponse> getListModuleByFormation(String uuidFormation);


    public List<ModuleResponse> getListModuleByClass(String uuidClass);

}
