package sn.forcen.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.forcen.entities.Role;
import sn.forcen.entities.Utilisateur;
import sn.forcen.repository.UtilisateurRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = Utilisateur.builder()
                .prenom(request.getPrenom())
                .nom(request.getNom())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
//                .role(new Role()).role()
                .build();

        return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }
}
