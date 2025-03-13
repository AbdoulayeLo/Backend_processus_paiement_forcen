package sn.forcen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.forcen.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
