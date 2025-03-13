package sn.forcen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.forcen.entities.Consultant;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant,Long> {
}
