package sn.forcen.dtos;

import lombok.Data;

@Data
public class ConsultantDTO extends UtilisateurDTO{
    private String competence;
    private String specialiste;
    private double renumeration;
}
