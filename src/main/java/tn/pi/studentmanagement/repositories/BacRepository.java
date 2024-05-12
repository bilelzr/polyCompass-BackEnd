package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.Bac;


@Repository
public interface BacRepository extends JpaRepository<Bac, Long> {


}
