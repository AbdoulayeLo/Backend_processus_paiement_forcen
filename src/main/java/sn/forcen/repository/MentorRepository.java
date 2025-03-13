package sn.forcen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.forcen.entities.Mentor;
@Repository
public interface MentorRepository extends JpaRepository<Mentor,Long> {
}
