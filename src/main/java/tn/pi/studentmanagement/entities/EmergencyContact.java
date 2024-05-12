package tn.pi.studentmanagement.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emergency_contact")
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emergency_contact_sequence")
    @SequenceGenerator(name = "emergency_contact_sequence", sequenceName = "emergency_contact_sequence", allocationSize = 1)
    @Column(name = "emergency_contact_pk")
    private long idEmergencyContact;
    private String name;
    private String studentRelated;
    private long phoneNumber;

}
