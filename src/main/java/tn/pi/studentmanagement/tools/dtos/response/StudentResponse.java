package tn.pi.studentmanagement.tools.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Builder
@Data
public class StudentResponse {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String codeEtudiant;
    private long cin;
    private String nationalite;
    private long numPassport;
    private LocalDate dateNaissance;
    private LocalDate dateInscrit;
    private String inscritLevel;
    private String curentLevel;
    private String photo;
    private boolean professionnel;
    private List<PostBacResponse> postBacList;
    private BacResponse bac;
    private EmergencyContactResponse emergencyContact;
    private String address;
    private String zipCode;
}
