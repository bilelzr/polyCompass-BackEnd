package tn.pi.studentmanagement.tools.dtos.request;

import lombok.Builder;
import lombok.Getter;
import tn.pi.studentmanagement.entities.Tag;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class FormationRequest {

    private String libelle;

    private String duree;

    private UUID uuid;

    private String description;


    private List<Tag> tagList;

    //   private Set<Module> moduleList;
}
