package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.Absence;


@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
