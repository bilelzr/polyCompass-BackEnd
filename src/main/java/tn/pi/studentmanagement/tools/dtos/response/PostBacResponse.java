package tn.pi.studentmanagement.tools.dtos.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PostBacResponse {
    private String ecole;
    private String nomDiplome;
    private LocalDate annee;
    private String moy;
    private boolean prepa;
}
