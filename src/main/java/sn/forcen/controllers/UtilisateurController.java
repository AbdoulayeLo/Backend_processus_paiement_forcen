package sn.forcen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forcen.entities.Utilisateur;
import sn.forcen.services.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur){
        try{
            Utilisateur addUtilisateur = utilisateurService.createUtilisateur(utilisateur);
            return ResponseEntity.status(201).body(addUtilisateur);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    //Modifier Utilisateur
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
//    ResponseEntity<Utilisateur>
    public ResponseEntity<?> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            Utilisateur modifUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
            return ResponseEntity.status(201).body(modifUtilisateur); // HTTP 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // HTTP 404 Not Found
        }
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
