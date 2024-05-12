package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.Formation;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    Optional<Formation> findFormationByLibelle(String libelle);

    Optional<Formation> findFormationByUuid(UUID uuid);


}
