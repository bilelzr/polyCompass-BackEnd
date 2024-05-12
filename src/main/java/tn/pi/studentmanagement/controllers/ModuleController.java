package tn.pi.studentmanagement.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.studentmanagement.services.ModuleService;
import tn.pi.studentmanagement.tools.dtos.request.ModuleRequest;
import tn.pi.studentmanagement.tools.dtos.response.ModuleResponse;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/module")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ModuleResponse>> getAllModule() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }


    @GetMapping("/getByCode/{code}")
    public ResponseEntity<ModuleResponse> getModuleByCode(@PathVariable String code) {
        return ResponseEntity.ok(moduleService.getModuleByCode(code));
    }

    @GetMapping("/getByLibelle/{libelle}")
    public ResponseEntity<ModuleResponse> getModuleLibelle(@PathVariable String libelle) {
        return ResponseEntity.ok(moduleService.getModuleByLibelle(libelle));
    }

    @PostMapping("/new")
    public ResponseEntity<ModuleResponse> createNewModule(@RequestBody ModuleRequest moduleRequest) {
        return ResponseEntity.ok(moduleService.createNewModule(moduleRequest));
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Object> deleteFormation(@PathVariable("code") String code) {
        return new ResponseEntity<>(moduleService.deleteModule(code), HttpStatus.OK);
    }

    @GetMapping("/getByFormation/{uuid}")
    public ResponseEntity<List<ModuleResponse>> getListModuleByFormation(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(moduleService.getListModuleByFormation(uuid), HttpStatus.OK);
    }

    @GetMapping("/getByClass/{uuid}")
    public ResponseEntity<List<ModuleResponse>> getListModuleByClass(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(moduleService.getListModuleByClass(uuid), HttpStatus.OK);
    }
}
