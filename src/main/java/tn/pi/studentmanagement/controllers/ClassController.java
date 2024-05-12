package tn.pi.studentmanagement.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.studentmanagement.services.ClassService;
import tn.pi.studentmanagement.tools.dtos.request.ClassStudentRequest;
import tn.pi.studentmanagement.tools.dtos.response.ClassStudentResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/class")
@CrossOrigin(origins = "*")
public class ClassController {


    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClassStudentResponse>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/byName")
    public ResponseEntity<List<ClassStudentResponse>> getAllClassesByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(classService.getAllClassesByName(name));
    }

    @GetMapping("/byYear")
    public ResponseEntity<List<ClassStudentResponse>> getAllClassesByYear(@RequestParam("year") LocalDate year) {
        return ResponseEntity.ok(classService.getAllClassesByYear(year));
    }

    @GetMapping("/byNameAndYear")
    public ResponseEntity<ClassStudentResponse> getAllClassesByYear(@RequestParam("name") String name, @RequestParam("year") LocalDate year) {
        return ResponseEntity.ok(classService.getClassByNameAndYear(name, year));
    }

    @GetMapping("/findbyUuid/{uuid}")
    public ResponseEntity<ClassStudentResponse> getAllClassesByYear(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(classService.findClassByUuid(uuid));
    }

    @PostMapping("/create")
    public ResponseEntity<ClassStudentResponse> createNewClass(@RequestBody ClassStudentRequest classStudentRequest) {
        return ResponseEntity.ok(classService.createClass(classStudentRequest));
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Boolean> deleteClass(@PathVariable("uuid") String classUuid) {
        return ResponseEntity.ok(classService.deleteClassByUUid(classUuid));
    }
}
