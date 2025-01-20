package sn.forcen.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
/***
?Recommande une normalisation où chaque sous-classe a sa propre table liée à celle de la classe parente.
 */
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    private String sexe;
    private Date dateNaiss;
    private String email;
    private String password;
    private Integer telephone;
    private String nationalite;
    private String paysResidence;
    private String villeResidence;

    /**
     *  // Attribut pour l'archivage d'utilisateur
     */
    private boolean isArchived = false;
}
