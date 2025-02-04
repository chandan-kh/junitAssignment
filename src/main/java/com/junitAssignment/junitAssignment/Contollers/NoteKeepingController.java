package com.junitAssignment.junitAssignment.Contollers;


import com.junitAssignment.junitAssignment.Requests.AddNoteRequests;
import com.junitAssignment.junitAssignment.Responses.GetResp;
import com.junitAssignment.junitAssignment.Services.NoteKeepingServices;
import com.junitAssignment.junitAssignment.Services.impl.NoteKeepingServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("notebook")
@Service
@RestController
@Validated
@Slf4j

public class NoteKeepingController {

    private final NoteKeepingServicesImpl noteKeepingServices;

    @PostMapping
    public String createNote(@RequestBody AddNoteRequests addNoteRequests){
        log.info("[createNote] NoteKeppingController");
        return noteKeepingServices.createNote(addNoteRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetResp> getNote(@PathVariable int id){
        log.info("id : " + id);
        GetResp resp = new GetResp();
        resp = noteKeepingServices.getNote(id);
        return ResponseEntity.ok().body(resp);
    }

    @DeleteMapping("/{id}")
    public String delNote(@PathVariable int id){
        log.info("id : " + id);
        noteKeepingServices.delNote(id);
        return "Deleted id successfully";
    }

    @PostMapping("/{id}")
    public String updateNote(@RequestBody AddNoteRequests addNoteRequests,@PathVariable int id){
        log.info("[createNote] NoteKeppingController");
        return noteKeepingServices.updateNote(addNoteRequests,id);
    }



}
