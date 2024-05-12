package tn.pi.studentmanagement.services;


import org.springframework.stereotype.Service;
import tn.pi.studentmanagement.entities.Absence;
import tn.pi.studentmanagement.repositories.AbsenceRepository;
import tn.pi.studentmanagement.repositories.ModuleRepository;
import tn.pi.studentmanagement.repositories.StudentRepository;
import tn.pi.studentmanagement.tools.dtos.DtoMapper;
import tn.pi.studentmanagement.tools.dtos.Tools;
import tn.pi.studentmanagement.tools.dtos.request.AbsenceRequest;
import tn.pi.studentmanagement.tools.dtos.response.StudentResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    private final StudentRepository studentRepository;
    private final ModuleRepository moduleRepository;

    private final AbsenceRepository absenceRepository;

    public AbsenceServiceImpl(StudentRepository studentRepository, ModuleRepository moduleRepository, AbsenceRepository absenceRepository) {
        this.studentRepository = studentRepository;
        this.moduleRepository = moduleRepository;
        this.absenceRepository = absenceRepository;
    }


    @Override
    public List<StudentResponse> findAbsenceStudentByDate(LocalDate date, String uuidClass, String code) {
        return DtoMapper.mapListStudentToDto(studentRepository.findAbsenceStudentByDate(date, UUID.fromString(uuidClass), code));
    }

    @Override
    public List<StudentResponse> findAbsenceStudentByModule(String codeModule) {
        return DtoMapper.mapListStudentToDto(studentRepository.findAbsenceStudentByModule(codeModule));
    }

    @Override
    public List<StudentResponse> findAbsenceStudentByModuleAndDate(String codeModule, LocalDate date) {
        return DtoMapper.mapListStudentToDto(studentRepository.findAbsenceStudentByModuleAndDate(codeModule, date));
    }

    @Override
    public void createAbsence(List<AbsenceRequest> absenceRequests) {
        List<Absence> absenceListToPersist = new ArrayList<>();
        absenceRequests.forEach(absenceRequest -> {
            Absence absence = new Absence();
            absence.setAbsenceDate(Tools.parseDateStringScore(absenceRequest.getAbsenceDate()));

            absence.setStudent(studentRepository.findStudentByUuid(absenceRequest.getStudent().getUuid()).orElse(null));
            absence.setModule(moduleRepository.findModuleByCode(absenceRequest.getModule().getCode()).orElse(null));
            absence.setUuid(UUID.randomUUID());
            absenceListToPersist.add(absence);
        });
        absenceRepository.saveAll(absenceListToPersist);
    }
}
