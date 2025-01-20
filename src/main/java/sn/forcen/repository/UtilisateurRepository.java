package sn.forcen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.forcen.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
