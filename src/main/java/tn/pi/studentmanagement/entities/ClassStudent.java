package tn.pi.studentmanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "year"})})
public class ClassStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_sequence")
    @SequenceGenerator(name = "class_sequence", sequenceName = "class_sequence", allocationSize = 1)
    @Column(name = "class_pk")
    private long idClass;

    private String name;
    private LocalDate year;

    private UUID uuid;

    @ManyToOne // Change cascade type
    @JoinColumn(name = "formation_pk", referencedColumnName = "formation_pk")
    private Formation formation;

    @ManyToMany(mappedBy = "studentClassList")
    private Set<Student> studentList = new HashSet<>();
}
