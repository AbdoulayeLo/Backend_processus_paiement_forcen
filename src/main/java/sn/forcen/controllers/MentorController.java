package sn.forcen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forcen.dtos.MentorDTO;
import sn.forcen.services.MentorService;

import java.util.List;

@RestController
@RequestMapping("/mentors")
public class MentorController {
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    public ResponseEntity <List<MentorDTO>> getAllMentors(){
        List<MentorDTO> mentorDTO =mentorService.AllMentors();
        return ResponseEntity.ok(mentorDTO);

    }

    @PostMapping
    public ResponseEntity<MentorDTO> creatMentor(@RequestBody MentorDTO mentorDTO){
        MentorDTO mentor = mentorService.createMentor(mentorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mentor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentorDTO> updateMentor(@PathVariable Long id, @RequestBody MentorDTO mentorDTO){
        MentorDTO mentor  = mentorService.updateMentor(id,mentorDTO);
        return ResponseEntity.ok(mentor);
    }
}
