package tn.pi.studentmanagement.tools.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class FormationResponse {

    private String libelle;
    private String duree;
    private UUID uuid;
    private String description;
    private List<TagResponse> tagList;

}
