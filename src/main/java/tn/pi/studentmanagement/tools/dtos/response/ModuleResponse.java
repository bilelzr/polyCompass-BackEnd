package tn.pi.studentmanagement.tools.dtos.response;

import lombok.Builder;
import lombok.Data;
import tn.pi.studentmanagement.entities.Semester;

@Data
@Builder
public class ModuleResponse {
    private String code;
    private String libelle;
    private String description;
    private long coefficient;
    private long credit;
    private Semester semester;
}
