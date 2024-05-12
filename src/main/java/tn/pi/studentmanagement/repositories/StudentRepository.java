package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByUuid(UUID uuidStudent);

    Optional<Student> findStudentByCodeEtudiant(String codeStudent);


    @Query("SELECT student FROM Student student " +
            "JOIN student.studentClassList class " +
            "WHERE class.uuid = :uuidClass")
    List<Student> findStudentByUuidClass(UUID uuidClass);


    @Query("SELECT DISTINCT student FROM Student student " +
            "JOIN student.absences absence " +
            "WHERE absence.absenceDate = :date " +
            "and :uuid IN (SELECT class.uuid FROM student.studentClassList class) " +
            "and :code IN (SELECT module.code FROM absence.module module)")
    List<Student> findAbsenceStudentByDate(@Param("date") LocalDate date,
                                           @Param("uuid") UUID uuidClass,
                                           @Param("code") String code );


    @Query("SELECT DISTINCT student FROM Student  student " +
            "JOIN Absence absence " +
            "JOIN Module module " +
            "WHERE module.code = :code ")
    List<Student> findAbsenceStudentByModule(@Param("code") String code);

    @Query("SELECT DISTINCT student FROM Student  student " +
            "JOIN Absence absence " +
            "JOIN Module module " +
            "WHERE module.code = :code " +
            "and absence.absenceDate = :date")
    List<Student> findAbsenceStudentByModuleAndDate(@Param("code") String code, @Param("date") LocalDate date);
}
