package sn.forcen.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String RoleName;

    @OneToMany
    @JoinColumn(name = "role_id")
    private Set<Utilisateur> utilisateurs;
}
