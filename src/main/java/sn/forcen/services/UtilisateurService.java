package sn.forcen.services;

import org.springframework.stereotype.Service;
import sn.forcen.entities.Utilisateur;
import sn.forcen.repository.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> ListUtilisateurs(){
       return utilisateurRepository.findAll();
    }

/***    public Utilisateur findUtilisateurById(Long id){
        Optional<Utilisateur> utilisateur=utilisateurRepository.findById(id);
        if (utilisateur.isEmpty()){
           return null;
        }else {
        return utilisateur.get();
        }
    }  ***/
    public Utilisateur findUtilisateurById(Long id){
        return utilisateurRepository.findById(id).orElseThrow(()->new RuntimeException("Utilisateur non trouve!!!"));
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur){
        Optional<Utilisateur> getUtilisateur = utilisateurRepository.findById(utilisateur.getId());
        if (getUtilisateur.isEmpty()){
           return null;
        }else {
            return  utilisateurRepository.save(utilisateur);
        }
    }

    public void archiverUtilisateur(Long id){
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Utilisateur introuvable"));
        utilisateur.setArchived(true);
        utilisateurRepository.save(utilisateur);
    }

    public void desArchverUtilisateur(Long id){
        Utilisateur utilisateur= utilisateurRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Utilisateur introuvable"));
        utilisateur.setArchived(false);
        utilisateurRepository.save(utilisateur);
    }






}
