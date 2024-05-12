package tn.pi.studentmanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @Column(name = "student_pk")
    private long idEmployee;
    private UUID uuid;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    @Column(unique = true)
    private String codeEtudiant;
    private long cin;
    @Column(unique = true)
    private String email;
    private String nationalite;
    private long numPassport;
    private LocalDate dateNaissance;
    private LocalDate dateInscrit;
    private String inscritLevel;
    private String curentLevel;
    private String address;
    private String zipCode;
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_contact_pk", referencedColumnName = "emergency_contact_pk")
    private EmergencyContact emergencyContact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bac_pk", referencedColumnName = "bac_pk")
    private Bac bac;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<PostBac> postBacList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "class_student",
            joinColumns = @JoinColumn(name = "student_pk"), // Mapping to class table
            inverseJoinColumns = @JoinColumn(name = "class_pk"))
    private Set<ClassStudent> studentClassList = new HashSet<>();

    private boolean professionnel;

    private String photo;

    // One-to-many relationship with Absence
    @OneToMany(mappedBy = "student")
    private List<Absence> absences = new ArrayList<>();

}
