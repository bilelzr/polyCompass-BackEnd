package tn.pi.studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.studentmanagement.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
