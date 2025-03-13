package sn.forcen.services;

import org.springframework.stereotype.Service;
import sn.forcen.dtos.MentorDTO;
import sn.forcen.entities.Mentor;
import sn.forcen.repository.MentorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public MentorDTO convertToDTO(Mentor mentor){
        MentorDTO mentorDTO = new MentorDTO();

//        Champs herite de Utilisateur
        mentorDTO.setNom(mentor.getNom());
        mentorDTO.setPrenom(mentor.getPrenom());
        mentorDTO.setEmail(mentor.getEmail());
        mentorDTO.setDateNaiss(mentor.getDateNaiss());
        mentorDTO.setNationalite(mentor.getNationalite());
        mentorDTO.setVilleResidence(mentor.getVilleResidence());
        mentorDTO.setTelephone(mentor.getTelephone());
        mentorDTO.setSexe(mentor.getSexe());
        mentorDTO.setRole_id(mentor.getRole_id());
        mentorDTO.setPaysResidence(mentor.getPaysResidence());

//        Champs Specifique a mentor
        mentorDTO.setCompetence(mentor.getCompetence());
        mentorDTO.setDomaineMentorat(mentor.getDomaineMentorat());
        mentorDTO.setNombreSession(mentor.getNombreSession());

        return mentorDTO;
    }

    public List<MentorDTO> AllMentors(){
         List<Mentor> mentors=mentorRepository.findAll();
         return mentors.stream()
                 .map(this::convertToDTO)
                 .collect(Collectors.toList());
    }

    public MentorDTO createMentor(MentorDTO mentorDTO){
        Mentor mentor = new Mentor();

        mentor.setNom(mentorDTO.getNom());
        mentor.setPrenom(mentorDTO.getPrenom());
        mentor.setEmail(mentorDTO.getEmail());
        mentor.setDateNaiss(mentorDTO.getDateNaiss());
        mentor.setNationalite(mentorDTO.getNationalite());
        mentor.setVilleResidence(mentorDTO.getVilleResidence());
        mentor.setTelephone(mentorDTO.getTelephone());
        mentor.setSexe(mentorDTO.getSexe());
        mentor.setRole_id(mentorDTO.getRole_id());
        mentor.setPaysResidence(mentorDTO.getPaysResidence());
        mentor.setCompetence(mentorDTO.getCompetence());
        mentor.setDomaineMentorat(mentorDTO.getDomaineMentorat());
        mentor.setNombreSession(mentorDTO.getNombreSession());

        mentor=mentorRepository.save(mentor);
        return convertToDTO(mentor);
    }

    public MentorDTO updateMentor(Long id ,MentorDTO mentorDTO){
//        Trouver le mentor existant
        Mentor existingMentor = mentorRepository.findById(id).orElseThrow(()->
                new RuntimeException("Mentor avec id "+id +" est introuvable ")
        );
        existingMentor.setNom(mentorDTO.getNom());
        existingMentor.setPrenom(mentorDTO.getPrenom());
        existingMentor.setEmail(mentorDTO.getEmail());
        existingMentor.setDateNaiss(mentorDTO.getDateNaiss());
        existingMentor.setNationalite(mentorDTO.getNationalite());
        existingMentor.setVilleResidence(mentorDTO.getVilleResidence());
        existingMentor.setTelephone(mentorDTO.getTelephone());
        existingMentor.setSexe(mentorDTO.getSexe());
        existingMentor.setRole_id(mentorDTO.getRole_id());
        existingMentor.setPaysResidence(mentorDTO.getPaysResidence());
        existingMentor.setCompetence(mentorDTO.getCompetence());
        existingMentor.setDomaineMentorat(mentorDTO.getDomaineMentorat());
        existingMentor.setNombreSession(mentorDTO.getNombreSession());

        // Retourner le MentorDTO mis à jour
        existingMentor= mentorRepository.save(existingMentor);
        // Retourner le MentorDTO mis à jour
        return convertToDTO(existingMentor);
    }
}

