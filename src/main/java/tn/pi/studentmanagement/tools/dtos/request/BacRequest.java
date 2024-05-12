package tn.pi.studentmanagement.tools.dtos.request;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BacRequest {


    private String ecole;
    private String filiale;
    private LocalDate annee;
    private String moy;

}
