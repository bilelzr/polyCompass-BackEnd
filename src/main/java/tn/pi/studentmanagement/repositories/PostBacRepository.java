package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.PostBac;


@Repository
public interface PostBacRepository extends JpaRepository<PostBac, Long> {
}
