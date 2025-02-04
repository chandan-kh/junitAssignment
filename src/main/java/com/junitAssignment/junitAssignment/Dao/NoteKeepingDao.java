package com.junitAssignment.junitAssignment.Dao;

import com.junitAssignment.junitAssignment.Entity.NotebookEntity;
import com.junitAssignment.junitAssignment.Repository.NoteBookRepository;
import com.junitAssignment.junitAssignment.Requests.AddNoteRequests;
import com.junitAssignment.junitAssignment.Responses.GetResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service

public class NoteKeepingDao {

    private final NoteBookRepository repo;

    public String createNote(AddNoteRequests addNoteRequests){
        NotebookEntity entity = new NotebookEntity();
        entity.setUsername(addNoteRequests.getUsername());
        entity.setNote(addNoteRequests.getNote());
        repo.save(entity);
        return "Successfully added note";
    }

    public GetResp getNote(int id){

        NotebookEntity entity = new NotebookEntity();
        entity = repo.findById(id);

        GetResp resp = new GetResp();
        resp.setNote(entity.getNote());
        resp.setId(entity.getId());
        resp.setUsername(entity.getUsername());

        return resp;

    }

    public void delNote(int id){
        repo.deleteById(id);
    }

    public String updateNote(AddNoteRequests addNoteRequests,int id){

        NotebookEntity entity = new NotebookEntity();
        entity = repo.findById(id);

        entity.setUsername(addNoteRequests.getUsername());
        entity.setNote(addNoteRequests.getNote());
        repo.save(entity);

        return "Updated added note";
    }


}
