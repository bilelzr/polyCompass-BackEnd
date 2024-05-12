package tn.pi.studentmanagement.services;


import org.springframework.stereotype.Service;
import tn.pi.studentmanagement.entities.ClassStudent;
import tn.pi.studentmanagement.entities.PostBac;
import tn.pi.studentmanagement.entities.Student;
import tn.pi.studentmanagement.repositories.ClassRepository;
import tn.pi.studentmanagement.repositories.PostBacRepository;
import tn.pi.studentmanagement.repositories.StudentRepository;
import tn.pi.studentmanagement.tools.dtos.DtoMapper;
import tn.pi.studentmanagement.tools.dtos.request.StudentRequest;
import tn.pi.studentmanagement.tools.dtos.response.StudentResponse;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classStudentRepository;

    private final PostBacRepository postBacRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ClassRepository classStudentRepository, PostBacRepository postBacRepository) {
        this.studentRepository = studentRepository;
        this.classStudentRepository = classStudentRepository;
        this.postBacRepository = postBacRepository;
    }


    @Override
    public List<StudentResponse> getAllStudents() {
        return DtoMapper.mapListStudentToDto(studentRepository.findAll());
    }

    @Override
    public StudentResponse findStudentByUuid(String uuidStudent) {
        Optional<Student> student = studentRepository.findStudentByUuid(UUID.fromString(uuidStudent));
        return student.map(DtoMapper::mapStudentToDto).orElse(null);
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setCodeEtudiant(studentRequest.getCodeEtudiant());
        student.setCin(studentRequest.getCin());
        student.setEmail(studentRequest.getEmail());
        student.setNationalite(studentRequest.getNationalite());
        student.setNumPassport(studentRequest.getNumPassport());
        student.setDateNaissance(studentRequest.getDateNaissance());
        student.setDateInscrit(studentRequest.getDateInscrit());
        student.setInscritLevel(studentRequest.getInscritLevel());
        student.setCurentLevel(studentRequest.getCurentLevel());
        student.setEmergencyContact(studentRequest.getEmergencyContact());
        student.setPhoto(studentRequest.getPhoto());
        student.setBac(studentRequest.getBac());
        student.setProfessionnel(studentRequest.isProfessionnel());
        student.setUuid(UUID.randomUUID());
        List<PostBac> postBacList = new ArrayList<>();
        for (PostBac postBacRequest : studentRequest.getPostBacList()) {
            PostBac postBac = postBacRepository.findById(postBacRequest.getIdPostBac()).get();
            postBac.setEcole(postBacRequest.getEcole());
            postBac.setNomDiplome(postBacRequest.getNomDiplome());
            postBac.setAnnee(postBacRequest.getAnnee());
            postBac.setMoy(postBacRequest.getMoy());
            postBac.setPrepa(postBacRequest.isPrepa());
            // Set the Student for the PostBac entity
            postBac.setStudent(student);
            // Save the PostBac entity
            postBacList.add(postBac);
        }
        student.setPostBacList(postBacList);
        studentRepository.save(student);

        return DtoMapper.mapStudentToDto(student);
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest) {
        // Retrieve the existing student from the database
        Optional<Student> optionalStudent = studentRepository.findStudentByCodeEtudiant(studentRequest.getCodeEtudiant());
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            // Update the fields of the existing student with the values from studentRequest
            student.setFirstName(studentRequest.getFirstName());
            student.setLastName(studentRequest.getLastName());
            student.setPhoneNumber(studentRequest.getPhoneNumber());
            student.setCodeEtudiant(studentRequest.getCodeEtudiant());
            student.setCin(studentRequest.getCin());
            student.setEmail(studentRequest.getEmail());
            student.setNationalite(studentRequest.getNationalite());
            student.setNumPassport(studentRequest.getNumPassport());
            student.setDateNaissance(studentRequest.getDateNaissance());
            student.setDateInscrit(studentRequest.getDateInscrit());
            student.setInscritLevel(studentRequest.getInscritLevel());
            student.setCurentLevel(studentRequest.getCurentLevel());
            student.setEmergencyContact(studentRequest.getEmergencyContact());
            student.setPhoto(studentRequest.getPhoto());
            student.setBac(studentRequest.getBac());
            student.setProfessionnel(studentRequest.isProfessionnel());

            Set<ClassStudent> classStudents = handleClassForStudent(studentRequest);

            student.setStudentClassList(classStudents);
            // Clear existing postBacList and add updated ones from studentRequest
            List<PostBac> postBacList = new ArrayList<>();
            for (PostBac postBacRequest : studentRequest.getPostBacList()) {

            }
            student.setPostBacList(postBacList);

            // Save the updated student back to the database
            studentRepository.save(student);

            return DtoMapper.mapStudentToDto(student);
        } else {
            // Handle case when student with given ID is not found
            throw new RuntimeException("Student not found with code: " + studentRequest.getCodeEtudiant());
        }
    }

    @Override
    public List<StudentResponse> getClassByStudent(String uuidClass) {
        return DtoMapper.mapListStudentToDto(studentRepository.findStudentByUuidClass(UUID.fromString(uuidClass)));
    }

    private Set<ClassStudent> handleClassForStudent(StudentRequest studentRequest) {
        Set<ClassStudent> classStudents = new HashSet<>();
        if (studentRequest.getClassStudentList() != null) {
            studentRequest.getClassStudentList().forEach(classStudentRequest -> {
                Optional<ClassStudent> classStudent = classStudentRepository.findClassEtudiantByNameAndYear(classStudentRequest.getName(), classStudentRequest.getYear());
                classStudents.add(Objects.requireNonNull(classStudent.get()));
            });
        }
        return classStudents;
    }

}
