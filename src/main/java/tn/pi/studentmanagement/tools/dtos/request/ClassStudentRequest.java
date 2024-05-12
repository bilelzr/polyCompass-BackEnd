package tn.pi.studentmanagement.tools.dtos.request;

import lombok.Builder;
import lombok.Getter;
import tn.pi.studentmanagement.entities.Formation;

import java.time.LocalDate;

@Getter
@Builder
public class ClassStudentRequest {

    private String name;
    private LocalDate year;
    private Formation formation;

}
