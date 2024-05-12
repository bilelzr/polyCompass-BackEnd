package tn.pi.studentmanagement.services;

import tn.pi.studentmanagement.tools.dtos.request.StudentRequest;
import tn.pi.studentmanagement.tools.dtos.response.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudents();

    StudentResponse findStudentByUuid(String uuidStudent);

    StudentResponse createStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(StudentRequest studentRequest);

    List<StudentResponse> getClassByStudent(String uuidClass);
}
