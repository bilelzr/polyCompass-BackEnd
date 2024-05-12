package tn.pi.studentmanagement.services;

import tn.pi.studentmanagement.tools.dtos.request.ClassStudentRequest;
import tn.pi.studentmanagement.tools.dtos.response.ClassStudentResponse;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {

    ClassStudentResponse createClass(ClassStudentRequest classStudentRequest);

    List<ClassStudentResponse> getAllClasses();

    ClassStudentResponse findClassByUuid(String uuid);

    List<ClassStudentResponse> getAllClassesByName(String name);


    boolean deleteClassByUUid(String uuid);

    List<ClassStudentResponse> getAllClassesByYear(LocalDate year);

    ClassStudentResponse getClassByNameAndYear(String name, LocalDate year);
}
