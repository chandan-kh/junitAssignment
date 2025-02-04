package com.junitAssignment.junitAssignment.DaoTest;

import com.junitAssignment.junitAssignment.Dao.NoteKeepingDao;
import com.junitAssignment.junitAssignment.Entity.NotebookEntity;
import com.junitAssignment.junitAssignment.Repository.NoteBookRepository;
import com.junitAssignment.junitAssignment.Requests.AddNoteRequests;
import com.junitAssignment.junitAssignment.Responses.GetResp;
import com.junitAssignment.junitAssignment.Services.impl.NoteKeepingServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class NoteKeepingDaoTest {

    @InjectMocks
    private NoteKeepingDao noteKeepingDao;

    @Mock
    private NoteBookRepository repo;

    private NotebookEntity entity;
    private AddNoteRequests addNoteRequests;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Ensures all @Mock fields are initialized

        entity = new NotebookEntity();
        entity.setId(1);
        entity.setUsername("testUser");
        entity.setNote("Test Note");

        addNoteRequests = new AddNoteRequests();
        addNoteRequests.setUsername("testUser");
        addNoteRequests.setNote("Updated Test Note");
    }


    @Test
    void testCreateNote() {
        when(repo.save(any(NotebookEntity.class))).thenReturn(entity);

        String response = noteKeepingDao.createNote(addNoteRequests);

        assertEquals("Successfully added note", response);

    }

    @Test
    void testGetNote() {
        when(repo.findById(1)).thenReturn(entity);

        GetResp response = noteKeepingDao.getNote(1);

        assertNotNull(response);
        assertEquals(1, response.getId());
        assertEquals("testUser", response.getUsername());
        assertEquals("Test Note", response.getNote());

    }

    @Test
    void testDeleteNote() {
        doNothing().when(repo).deleteById(1);
        noteKeepingDao.delNote(1);
    }

    @Test
    void testUpdateNote() {
        when(repo.findById(1)).thenReturn(entity);
        when(repo.save(any(NotebookEntity.class))).thenReturn(entity);

        String response = noteKeepingDao.updateNote(addNoteRequests, 1);

        assertEquals("Updated added note", response);

    }


}
