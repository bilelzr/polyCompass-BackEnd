package tn.pi.studentmanagement.tools.dtos.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PostBacRequest {

    private String ecole;
    private String nomDiplome;
    private LocalDate annee;
    private String moy;
    private boolean prepa;

}
