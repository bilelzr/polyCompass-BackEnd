package tn.pi.studentmanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formation_sequence")
    @SequenceGenerator(name = "formation_sequence", sequenceName = "formation_sequence", allocationSize = 1)
    @Column(name = "formation_pk")
    private long idFormation;


    private UUID uuid;

    private String libelle;
    private String duree;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "formationList")
    private List<Tag> tagList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "formation_module",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"module_id", "formation_id"})
    )
    private List<Module> moduleList = new ArrayList<>();
}
