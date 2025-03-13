package sn.forcen.services;

import org.springframework.stereotype.Service;
import sn.forcen.dtos.ConsultantDTO;
import sn.forcen.entities.Consultant;
import sn.forcen.repository.ConsultantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;

    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public ConsultantDTO convertToDTO(Consultant consultant){
        ConsultantDTO consultantDTO = new ConsultantDTO();


//        Champs herite de consultant
        consultantDTO.setNom(consultant.getNom());
        consultantDTO.setPrenom(consultant.getPrenom());
        consultantDTO.setEmail(consultant.getEmail());
        consultantDTO.setDateNaiss(consultant.getDateNaiss());
        consultantDTO.setNationalite(consultant.getNationalite());
        consultantDTO.setVilleResidence(consultant.getVilleResidence());
        consultantDTO.setTelephone(consultant.getTelephone());
        consultantDTO.setSexe(consultant.getSexe());
        consultantDTO.setRole_id(consultant.getRole_id());
        consultantDTO.setPaysResidence(consultant.getPaysResidence());

//        Champs Specifique a consultant
        consultantDTO.setCompetence(consultant.getCompetence());
        consultantDTO.setSpecialiste(consultant.getSpecialiste());

        return consultantDTO;
    }

    public List<ConsultantDTO> getAllConsultants(){
        List<Consultant> consultants = consultantRepository.findAll();
        return consultants.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConsultantDTO createConsultant(ConsultantDTO consultantDTO){
        Consultant consultant = new Consultant();

        consultant.setNom(consultantDTO.getNom());
        consultant.setPrenom(consultantDTO.getPrenom());
        consultant.setEmail(consultantDTO.getEmail());
        consultant.setDateNaiss(consultantDTO.getDateNaiss());
        consultant.setNationalite(consultantDTO.getNationalite());
        consultant.setVilleResidence(consultantDTO.getVilleResidence());
        consultant.setTelephone(consultantDTO.getTelephone());
        consultant.setSexe(consultantDTO.getSexe());
        consultant.setRole_id(consultantDTO.getRole_id());
        consultant.setPaysResidence(consultantDTO.getPaysResidence());
        consultant.setCompetence(consultantDTO.getCompetence());
        consultant.setSpecialiste(consultantDTO.getSpecialiste());
        consultant.setRenumeration(consultantDTO.getRenumeration());

        consultant= consultantRepository.save(consultant);
        return convertToDTO(consultant);
    }

    public ConsultantDTO updateConsultant (Long id , ConsultantDTO consultantDTO){
        Consultant existingConsultant = consultantRepository.findById(id).orElseThrow(()->
                new RuntimeException("le consultant avec l'ID "+id+ "est introuvable")
        );
        existingConsultant.setNom(consultantDTO.getNom());
        existingConsultant.setPrenom(consultantDTO.getPrenom());
        existingConsultant.setEmail(consultantDTO.getEmail());
        existingConsultant.setDateNaiss(consultantDTO.getDateNaiss());
        existingConsultant.setNationalite(consultantDTO.getNationalite());
        existingConsultant.setVilleResidence(consultantDTO.getVilleResidence());
        existingConsultant.setTelephone(consultantDTO.getTelephone());
        existingConsultant.setSexe(consultantDTO.getSexe());
        existingConsultant.setRole_id(consultantDTO.getRole_id());
        existingConsultant.setPaysResidence(consultantDTO.getPaysResidence());
        existingConsultant.setCompetence(consultantDTO.getCompetence());
        existingConsultant.setSpecialiste(consultantDTO.getSpecialiste());
        existingConsultant.setRenumeration(consultantDTO.getRenumeration());

        existingConsultant=consultantRepository.save(existingConsultant);
        return convertToDTO(existingConsultant);
    }
}
