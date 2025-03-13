package sn.forcen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forcen.dtos.ConsultantDTO;
import sn.forcen.services.ConsultantService;

import java.util.List;

@RestController
@RequestMapping("consultants")
public class ConsultantController{
    private final ConsultantService consultantService;

    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultantDTO>> getAllConsultants(){
        List<ConsultantDTO> consultantDTOS =consultantService.getAllConsultants();
        return ResponseEntity.ok(consultantDTOS);
    }

    @PostMapping
    public ResponseEntity<ConsultantDTO> addConsultant(ConsultantDTO consultantDTO){
        ConsultantDTO consultantDTO1 = consultantService.createConsultant(consultantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultantDTO1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultantDTO> createConsultant(@PathVariable Long id,@RequestBody ConsultantDTO consultantDTO){
        ConsultantDTO consultant = consultantService.updateConsultant(id,consultantDTO);
        return ResponseEntity.ok(consultant);
    }
}
