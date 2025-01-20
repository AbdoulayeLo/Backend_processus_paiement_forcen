package sn.forcen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.forcen.entities.Mentor;

public interface MentorConsultant extends JpaRepository<Mentor,Long> {
}
