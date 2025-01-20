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
@Table
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String prenom;
    private String nom;
    private String sexe;
    private Date dateNaiss;
    private String email;
    private String password;
    private int telephone;
    private String nationalite;
    private String paysResidence;
    private String villeResidence;
}
