package tn.pi.studentmanagement.tools.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


@Builder
@Data
public class ClassStudentResponse {

    private String name;
    private UUID uuid;
    private LocalDate year;
    private FormationResponse formation;
    private StudentResponse studentResponse;
}
