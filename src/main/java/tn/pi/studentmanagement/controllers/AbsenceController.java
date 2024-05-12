package tn.pi.studentmanagement.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.studentmanagement.services.AbsenceService;
import tn.pi.studentmanagement.tools.dtos.Tools;
import tn.pi.studentmanagement.tools.dtos.request.AbsenceRequest;
import tn.pi.studentmanagement.tools.dtos.response.StudentResponse;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/absence")
public class AbsenceController {


    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }


    @GetMapping("/findByDate/{date}/{uuidClass}/{code}")
    public ResponseEntity<List<StudentResponse>> getAbsentStudentByDate(@PathVariable("date") String dateString,
                                                                        @PathVariable("uuidClass") String uuidClass,
                                                                        @PathVariable("code") String code) {
        return ResponseEntity.ok(absenceService.findAbsenceStudentByDate(Tools.parseDateStringScore(dateString),uuidClass,code));
    }

    @GetMapping("/findByModule/{codeModule}")
    public ResponseEntity<List<StudentResponse>> getAbsentStudentByModule(@PathVariable("codeModule") String codeModule) {
        return ResponseEntity.ok(absenceService.findAbsenceStudentByModule(codeModule));
    }


    @GetMapping("/findByModule&Date/{codeModule}/{date}")
    public ResponseEntity<List<StudentResponse>> getAbsentStudentByModule(@PathVariable("codeModule") String codeModule, @PathVariable("date") String dateString) {
        return ResponseEntity.ok(absenceService.findAbsenceStudentByModuleAndDate(codeModule, Tools.parseDateStringScore(dateString)));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAbsences(@RequestBody List<AbsenceRequest> absenceRequest) {
        absenceService.createAbsence(absenceRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
