package tn.pi.studentmanagement.tools.dtos.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagRequest {

    public String libelle;
}
