package sn.forcen.dtos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class UtilisateurDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String sexe;
    private Date dateNaiss;
    private String email;
    private Integer telephone;
    private String nationalite;
    private String paysResidence;
    private String villeResidence;
    private int role_id;


}
