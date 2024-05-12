package tn.pi.studentmanagement.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.studentmanagement.services.FormationService;
import tn.pi.studentmanagement.tools.dtos.request.FormationRequest;
import tn.pi.studentmanagement.tools.dtos.response.FormationResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formation")
@CrossOrigin(origins = "*")
public class FormationController {

    private final FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }


    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormationResponse> createFormation(@RequestBody FormationRequest formationRequest) {
        return ResponseEntity.ok(formationService.createFormation(formationRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FormationResponse>> getAllFormation() {
        return ResponseEntity.ok(formationService.getAllFormation());
    }


/*    @GetMapping("/find/{libelle}")
    public ResponseEntity<FormationResponse> getFormationByLibelle(@PathVariable("libelle") String libelle) {
        return ResponseEntity.ok(formationService.getFormationByLibelle(libelle));
    }*/

    @DeleteMapping("/delete/{libelle}")
    public ResponseEntity<Object> deleteFormation(@PathVariable("libelle") String libelle) {
        return new ResponseEntity<>(formationService.deleteFormation(libelle), HttpStatus.OK);
    }


    @GetMapping("/find/{uuid}")
    public ResponseEntity<Object> getFormationByUuid(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(formationService.getFormationByUiid(uuid), HttpStatus.OK);
    }

    @PostMapping("/addModules/{uuid}")
    public ResponseEntity<FormationResponse> addModulesToFormation(@PathVariable("uuid") String uuid, @RequestBody List<String> listCodeModules) {
        return new ResponseEntity<>(formationService.addListModuleToFormation(listCodeModules, uuid), HttpStatus.OK);
    }

}
