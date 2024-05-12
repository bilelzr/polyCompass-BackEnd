package tn.pi.studentmanagement.tools.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class BacResponse {

    private String ecole;
    private String filiale;
    private LocalDate annee;
    private String moy;
}
