package tn.pi.studentmanagement.services;

import tn.pi.studentmanagement.tools.dtos.request.FormationRequest;
import tn.pi.studentmanagement.tools.dtos.response.FormationResponse;

import java.util.List;

public interface FormationService {

    FormationResponse createFormation(FormationRequest formationRequest);

    List<FormationResponse> getAllFormation();

    FormationResponse getFormationByLibelle(String libelle);

    boolean deleteFormation(String libelle);

    FormationResponse getFormationByUiid(String uuid);

    FormationResponse addListModuleToFormation(List<String> codeModule, String uuidFormation);
}
