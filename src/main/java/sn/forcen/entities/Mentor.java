package sn.forcen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mentor extends Utilisateur{
    private double renumeration;
    private String competence;
    private String domaineMentorat;
    private int nombreSession;
}
