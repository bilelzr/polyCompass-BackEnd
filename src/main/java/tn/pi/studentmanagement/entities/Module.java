package tn.pi.studentmanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_sequence")
    @SequenceGenerator(name = "module_sequence", sequenceName = "module_sequence", allocationSize = 1)
    @Column(name = "module_pk")
    private long idModule;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String libelle;
    private String description;
    private long coefficient;
    private long credit;
    @Enumerated
    private Semester semester;

    @ManyToMany(mappedBy = "moduleList")
    private Set<Formation> formationList = new HashSet<>();

    @ManyToMany(mappedBy = "taughtModules")
    private Set<Teacher> teachers = new HashSet<>();

    // One-to-many relationship with Absence
    @OneToMany(mappedBy = "module")
    private List<Absence> absences = new ArrayList<>();
}
