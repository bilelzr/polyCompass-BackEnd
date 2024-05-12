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
@Table(name = "bac")
public class Bac {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bac_sequence")
    @SequenceGenerator(name = "bac_sequence", sequenceName = "bac_sequence", allocationSize = 1)
    @Column(name = "bac_pk")
    private long idBac;
    private String ecole;
    private String filiale;
    private LocalDate annee;
    private String moy;
}
