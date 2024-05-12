package tn.pi.studentmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @Column(name = "teacher_pk")
    private long idTeacher;

    @Column(name = "teacher_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "teacher_module",
            joinColumns = @JoinColumn(name = "teacher_pk"),
            inverseJoinColumns = @JoinColumn(name = "module_pk")
    )
    private Set<Module> taughtModules = new HashSet<>();
}
