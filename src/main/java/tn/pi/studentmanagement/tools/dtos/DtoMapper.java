package tn.pi.studentmanagement.tools.dtos;

import tn.pi.studentmanagement.entities.Module;
import tn.pi.studentmanagement.entities.*;
import tn.pi.studentmanagement.tools.dtos.response.*;

import java.util.ArrayList;
import java.util.List;

public class DtoMapper {

    private DtoMapper() {

    }

    public static UserResponse mapUserToDto(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .role(user.getRole().toString())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .accountStatus(user.isAccountNonLocked())
                .build();
    }

    public static List<UserResponse> mapListUserToDto(List<User> users) {
        List<UserResponse> userResponseList = new ArrayList<>();
        users.forEach(user -> userResponseList.add(mapUserToDto(user)));
        return userResponseList;
    }

    public static ClassStudentResponse mapClassToDto(ClassStudent classStudent) {
        return ClassStudentResponse.builder()
                .name(classStudent.getName())
                .uuid(classStudent.getUuid())
                .formation(mapFormationToDto(classStudent.getFormation()))
                .year(classStudent.getYear())
                .build();
    }

    public static List<ClassStudentResponse> mapListClassToDto(List<ClassStudent> classStudents) {
        List<ClassStudentResponse> classStudentResponseList = new ArrayList<>();
        classStudents.forEach(classStudent -> classStudentResponseList.add(mapClassToDto(classStudent)));
        return classStudentResponseList;
    }

    public static FormationResponse mapFormationToDto(Formation formation) {
        return FormationResponse.builder()
                .duree(formation.getDuree())
                .description(formation.getDescription())
                .tagList(mapListTagToDto(formation.getTagList()))
                .libelle(formation.getLibelle())
                .uuid(formation.getUuid())
                // .moduleList(formation.getModuleList())
                // .semester(formation.getSemester())
                .build();
    }

    public static List<FormationResponse> mapListFormationToDto(List<Formation> formationList) {
        List<FormationResponse> formationResponses = new ArrayList<>();
        formationList.forEach(formation -> formationResponses.add(mapFormationToDto(formation)));
        return formationResponses;
    }

    public static TagResponse mapTagToDto(Tag tag) {
        return TagResponse.builder()
                .libelle(tag.getLibelle())
                .build();
    }

    public static List<TagResponse> mapListTagToDto(List<Tag> tagList) {
        List<TagResponse> tagResponseList = new ArrayList<>();
        tagList.forEach(tag -> tagResponseList.add(mapTagToDto(tag)));
        return tagResponseList;
    }

    public static ModuleResponse mapModuleToDto(Module module) {
        return ModuleResponse.builder()
                .credit(module.getCredit())
                .code(module.getCode())
                .coefficient(module.getCoefficient())
                .semester(module.getSemester())
                .libelle(module.getLibelle())
                .description(module.getDescription())
                .build();
    }

    public static List<ModuleResponse> mapListModuleToDto(List<Module> modules) {
        List<ModuleResponse> moduleResponseList = new ArrayList<>();
        modules.forEach(module -> moduleResponseList.add(mapModuleToDto(module)));
        return moduleResponseList;
    }

    public static StudentResponse mapStudentToDto(Student student) {
        return StudentResponse.builder()
                .cin(student.getCin())
                .uuid(student.getUuid())
                .codeEtudiant(student.getCodeEtudiant())
                .curentLevel(student.getCurentLevel())
                .dateInscrit(student.getDateInscrit())
                .dateNaissance(student.getDateNaissance())
                .photo(student.getPhoto())
                .email(student.getEmail())
                .bac(mapBacToDto(student.getBac()))
                .postBacList(mapListPostBacToResponse(student.getPostBacList()))
                .emergencyContact(mapEmergencyContactToResponse(student.getEmergencyContact()))
                .inscritLevel(student.getInscritLevel())
                .nationalite(student.getNationalite())
                .numPassport(student.getNumPassport())
                .professionnel(student.isProfessionnel())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .zipCode(student.getZipCode())
                .address(student.getAddress())
                .build();
    }

    public static List<StudentResponse> mapListStudentToDto(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        students.forEach(student -> studentResponses.add(mapStudentToDto(student)));
        return studentResponses;
    }


    public static BacResponse mapBacToDto(Bac bac) {
        return BacResponse.builder()
                .ecole(bac.getEcole())
                .filiale(bac.getFiliale())
                .annee(bac.getAnnee())
                .moy(bac.getMoy())
                .build();
    }

    public static PostBacResponse mapPostBacToResponse(PostBac postBac) {
        return PostBacResponse.builder()
                .annee(postBac.getAnnee())
                .prepa(postBac.isPrepa())
                .nomDiplome(postBac.getNomDiplome())
                .ecole(postBac.getEcole())
                .moy(postBac.getMoy())
                .build();
    }

    public static List<PostBacResponse> mapListPostBacToResponse(List<PostBac> postBacList) {
        List<PostBacResponse> postBacRequestList = new ArrayList<>();
        postBacList.forEach(postBac -> postBacRequestList.add(mapPostBacToResponse(postBac)));
        return postBacRequestList;
    }

    public static EmergencyContactResponse mapEmergencyContactToResponse(EmergencyContact emergencyContact) {
        return EmergencyContactResponse.builder()
                .name(emergencyContact.getName())
                .phoneNumber(emergencyContact.getPhoneNumber())
                .studentRelated(emergencyContact.getStudentRelated())
                .build();
    }
}
