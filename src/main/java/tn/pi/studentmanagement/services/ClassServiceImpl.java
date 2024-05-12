package tn.pi.studentmanagement.services;


import org.springframework.stereotype.Service;
import tn.pi.studentmanagement.entities.ClassStudent;
import tn.pi.studentmanagement.repositories.ClassRepository;
import tn.pi.studentmanagement.repositories.FormationRepository;
import tn.pi.studentmanagement.tools.dtos.DtoMapper;
import tn.pi.studentmanagement.tools.dtos.request.ClassStudentRequest;
import tn.pi.studentmanagement.tools.dtos.response.ClassStudentResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final FormationRepository formationRepository;


    public ClassServiceImpl(ClassRepository classRepository, FormationRepository formationRepository) {
        this.classRepository = classRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public ClassStudentResponse createClass(ClassStudentRequest classStudentRequest) {
        ClassStudent classStudent = new ClassStudent();
        classStudent.setFormation(formationRepository.findFormationByUuid(classStudentRequest.getFormation().getUuid()).get());
        classStudent.setName(classStudentRequest.getName());
        classStudent.setUuid(UUID.randomUUID());
        classStudent.setYear(classStudentRequest.getYear());
        classRepository.save(classStudent);
        return DtoMapper.mapClassToDto(classStudent);
    }

    @Override
    public List<ClassStudentResponse> getAllClasses() {
        return DtoMapper.mapListClassToDto(classRepository.findAll());
    }

    @Override
    public ClassStudentResponse findClassByUuid(String uuid) {
        Optional<ClassStudent> classEtudiant = classRepository.findByUuid(UUID.fromString(uuid));
        return classEtudiant.map(DtoMapper::mapClassToDto).orElse(null);
    }

    @Override
    public List<ClassStudentResponse> getAllClassesByName(String name) {
        return DtoMapper.mapListClassToDto(classRepository.findClassEtudiantByName(name));
    }

    @Override
    public boolean deleteClassByUUid(String uuid) {
        Optional<ClassStudent> classEtudiant = classRepository.findByUuid(UUID.fromString(uuid));
        classEtudiant.ifPresent(classRepository::delete);
        return false;
    }

    @Override
    public List<ClassStudentResponse> getAllClassesByYear(LocalDate year) {
        return DtoMapper.mapListClassToDto(classRepository.findClassEtudiantByYear(year));
    }

    @Override
    public ClassStudentResponse getClassByNameAndYear(String name, LocalDate year) {
        Optional<ClassStudent> classEtudiant = classRepository.findClassEtudiantByNameAndYear(name, year);
        return classEtudiant.map(DtoMapper::mapClassToDto).orElse(null);
    }
}
