package sn.forcen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
/***
?Recommande une normalisation où chaque sous-classe a
 sa propre table liée à celle de la classe parente.
 */
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private int role_id;

    /**
     *  // Attribut pour l'archivage d'utilisateur
     */
    @Column(nullable = false)
    private boolean isArchived = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;

}
