package tn.pi.studentmanagement.services;

import tn.pi.studentmanagement.tools.dtos.request.AbsenceRequest;
import tn.pi.studentmanagement.tools.dtos.response.StudentResponse;

import java.time.LocalDate;
import java.util.List;

public interface AbsenceService {

    List<StudentResponse> findAbsenceStudentByDate(LocalDate date, String uuidClass, String code);

    List<StudentResponse> findAbsenceStudentByModule(String codeModule);

    List<StudentResponse> findAbsenceStudentByModuleAndDate(String codeModule, LocalDate date);


    void createAbsence(List<AbsenceRequest> absenceRequests);

}
