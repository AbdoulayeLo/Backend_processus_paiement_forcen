package sn.forcen.dtos;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class MentorDTO extends UtilisateurDTO{
    private String competence;
    private String domaineMentorat;
    private int nombreSession;
}