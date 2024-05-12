package tn.pi.studentmanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "absence_sequence")
    @SequenceGenerator(name = "absence_sequence", sequenceName = "absence_sequence", allocationSize = 1)
    @Column(name = "absence_pk")
    private long idAbsence;


    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "student_pk") // Assuming this is the foreign key column in Absence table
    private Student student;

    // Many-to-one relationship with Module
    @ManyToOne
    @JoinColumn(name = "module_pk") // Assuming this is the foreign key column in Absence table
    private Module module;


    private LocalDate absenceDate;

}
