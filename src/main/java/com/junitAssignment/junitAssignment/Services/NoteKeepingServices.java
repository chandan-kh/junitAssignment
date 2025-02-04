package com.junitAssignment.junitAssignment.Services;

import com.junitAssignment.junitAssignment.Requests.AddNoteRequests;
import com.junitAssignment.junitAssignment.Responses.GetResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface NoteKeepingServices {
    public String createNote(AddNoteRequests addNoteRequests);
    public GetResp getNote(int id);
    public void delNote(int id);
    public String updateNote(AddNoteRequests addNoteRequests,int id);
}
