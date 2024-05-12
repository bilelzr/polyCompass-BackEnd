package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.EmergencyContact;


@Repository
public interface EmergencyContractRepository extends JpaRepository<EmergencyContact, Long> {
}
