package tn.pi.studentmanagement.tools.dtos.request;


import lombok.Builder;
import lombok.Data;
import tn.pi.studentmanagement.entities.Module;
import tn.pi.studentmanagement.entities.Student;

import java.time.LocalDate;

@Builder
@Data
public class AbsenceRequest {

    private String absenceDate;

    private Student student;

    private Module module;

}
