package sn.forcen.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forcen.entities.Utilisateur;
import sn.forcen.services.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
//    Recuperer tout les Utilisateurs
    @GetMapping()
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs(){
        List<Utilisateur> utilisateurs = utilisateurService.ListUtilisateurs();
        return ResponseEntity.ok(utilisateurs); // HTTP 200 OK
    }

//    Recuperer un Utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id){
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
        if (utilisateur==null){
            return ResponseEntity.notFound().build(); //HTTp 404 NOT FOUND
        }
        return ResponseEntity.ok(utilisateur); //HTTP 200 OK
    }

    //Creer Un Utilisateur
    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(Utilisateur utilisateur){
        Utilisateur addUtilisateur = utilisateurService.createUtilisateur(utilisateur);
        return ResponseEntity.status(201).body(addUtilisateur);
    }

    // Archiver Utilisateur
    @PutMapping("/{id}/archiver")
    public ResponseEntity<String> archiverUtilisateur(@PathVariable Long id){
       utilisateurService.archiverUtilisateur(id);
        return ResponseEntity.ok("Utilisateur archiver avec success!!!");
    }

    @PutMapping("/{id}/desarchiver")
    public ResponseEntity<String> desArchiverUtilisateur(@PathVariable Long id){
        utilisateurService.desArchverUtilisateur(id);
        return ResponseEntity.ok("Utilisateur dearchiver avec success!!!");
    }
}
