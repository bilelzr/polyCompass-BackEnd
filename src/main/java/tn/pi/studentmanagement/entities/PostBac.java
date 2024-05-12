package tn.pi.studentmanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_bac")
public class PostBac {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_bac_sequence")
    @SequenceGenerator(name = "post_bac_sequence", sequenceName = "post_bac_sequence", allocationSize = 1)
    @Column(name = "post_bac_pk")
    private long idPostBac;
    private String ecole;
    private String nomDiplome;
    private LocalDate annee;
    private String moy;
    private boolean prepa;

    @ManyToOne
    @JoinColumn(name = "student_pk")
    private Student student;
}
