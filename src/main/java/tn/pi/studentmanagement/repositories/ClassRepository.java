package tn.pi.studentmanagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.ClassStudent;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClassRepository extends JpaRepository<ClassStudent, Long> {

    List<ClassStudent> findClassEtudiantByYear(LocalDate year);

    Optional<ClassStudent> findByUuid(UUID uuid);

    List<ClassStudent> findClassEtudiantByName(String name);

    Optional<ClassStudent> findClassEtudiantByNameAndYear(String name, LocalDate year);
}
