package com.junitAssignment.junitAssignment.Services.impl;

import com.junitAssignment.junitAssignment.Dao.NoteKeepingDao;
import com.junitAssignment.junitAssignment.Requests.AddNoteRequests;
import com.junitAssignment.junitAssignment.Responses.GetResp;
import com.junitAssignment.junitAssignment.Services.NoteKeepingServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Service

public class NoteKeepingServicesImpl implements NoteKeepingServices {

    private final NoteKeepingDao noteKeepingDao;

    public String createNote(AddNoteRequests addNoteRequests){
        return noteKeepingDao.createNote(addNoteRequests);
    }

    public GetResp getNote(int id){
        return noteKeepingDao.getNote(id);
    }

    public void delNote(int id){
        noteKeepingDao.delNote(id);
    }

    public String updateNote(AddNoteRequests addNoteRequests,int id){
        return noteKeepingDao.updateNote(addNoteRequests,id);
    }
}


