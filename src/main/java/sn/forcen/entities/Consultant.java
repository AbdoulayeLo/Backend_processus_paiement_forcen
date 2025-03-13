package sn.forcen.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Consultant extends Utilisateur{
    private double renumeration;
    private String competence;
    private String specialiste;
}
