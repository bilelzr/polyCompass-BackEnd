package tn.pi.studentmanagement.tools.dtos.request;

import lombok.Builder;
import lombok.Data;
import tn.pi.studentmanagement.entities.Bac;
import tn.pi.studentmanagement.entities.ClassStudent;
import tn.pi.studentmanagement.entities.EmergencyContact;
import tn.pi.studentmanagement.entities.PostBac;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class StudentRequest {

    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String codeEtudiant;
    private String email;
    private long cin;
    private String nationalite;
    private long numPassport;
    private LocalDate dateNaissance;
    private LocalDate dateInscrit;
    private String inscritLevel;
    private String curentLevel;
    private EmergencyContact emergencyContact;
    private String photo;
    private Bac bac;
    private List<PostBac> postBacList;
    private boolean professionnel;
    private String address;
    private String zipCode;
    private List<ClassStudent> classStudentList;

}
