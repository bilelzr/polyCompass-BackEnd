package tn.pi.studentmanagement.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.studentmanagement.services.StudentService;
import tn.pi.studentmanagement.tools.dtos.request.StudentRequest;
import tn.pi.studentmanagement.tools.dtos.response.StudentResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<StudentResponse>> findAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/find/{uuid}")
    public ResponseEntity<StudentResponse> getFormationByUuid(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(studentService.findStudentByUuid(uuid), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<StudentResponse> createNewStudent(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.createStudent(studentRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(studentRequest));
    }

    @GetMapping("/findByClass/{uuidClass}")
    public ResponseEntity<List<StudentResponse>> getAllStudentByClass(@PathVariable("uuidClass") String uuidClass) {
        return ResponseEntity.ok(studentService.getClassByStudent(uuidClass));
    }
}
