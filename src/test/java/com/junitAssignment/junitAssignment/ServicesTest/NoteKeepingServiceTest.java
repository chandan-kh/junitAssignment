package com.junitAssignment.junitAssignment.ServicesTest;

import com.junitAssignment.junitAssignment.Contollers.NoteKeepingController;
import com.junitAssignment.junitAssignment.Dao.NoteKeepingDao;
import com.junitAssignment.junitAssignment.Repository.NoteBookRepository;
import com.junitAssignment.junitAssignment.Requests.AddNoteRequests;
import com.junitAssignment.junitAssignment.Responses.GetResp;
import com.junitAssignment.junitAssignment.Services.impl.NoteKeepingServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class NoteKeepingServiceTest {

    @Mock
    private NoteKeepingDao noteKeepingDao;

    @Mock
    private NoteBookRepository noteBookRepository;

    @InjectMocks
    private NoteKeepingServicesImpl noteKeepingServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createNoteTest(){
        AddNoteRequests requests = new AddNoteRequests();
        requests.setUsername("Test");
        requests.setNote("Testing note");

        when(noteKeepingDao.createNote(requests)).thenReturn("Successfully added note");
        String response = noteKeepingServices.createNote(requests);
        assertEquals("Successfully added note", response);
    }

    @Test
    void delNoteTest() {
        int id = 1;
        when(noteBookRepository.existsById(id)).thenReturn(true);
        doNothing().when(noteKeepingDao).delNote(id);
        noteKeepingServices.delNote(id);
    }

    @Test
    void delNoteTestException() {
        int id = 1;
        when(noteBookRepository.existsById(id)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteKeepingServices.delNote(id));
    }

    @Test
    void updateNoteTest() {
        int id = 1;
        AddNoteRequests requests = new AddNoteRequests();
        requests.setUsername("Test");
        requests.setNote("Testing note");

        when(noteBookRepository.existsById(id)).thenReturn(true);
        when(noteKeepingDao.updateNote(requests, id)).thenReturn("Updated added note");
        String response = noteKeepingServices.updateNote(requests, id);

        assertEquals("Updated added note", response);
    }


    @Test
    void updateNoteTestException() {
        int id = 1;
        AddNoteRequests requests = new AddNoteRequests();
        requests.setUsername("Test");
        requests.setNote("Testing note");

        when(noteBookRepository.existsById(id)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteKeepingServices.updateNote(requests, id));
    }

    @Test
    void testGetNote() {
        int id = 1;
        GetResp mockResponse = new GetResp();
        mockResponse.setId(id);
        mockResponse.setUsername("testUser");
        mockResponse.setNote("Test note content");

        when(noteBookRepository.existsById(id)).thenReturn(true);
        when(noteKeepingDao.getNote(id)).thenReturn(mockResponse);

        GetResp response = noteKeepingServices.getNote(id);

        assertEquals(id, response.getId());
        assertEquals("testUser", response.getUsername());
        assertEquals("Test note content", response.getNote());
    }

    @Test
    void testGetNoteException() {
        int id = 1;
        when(noteBookRepository.existsById(id)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteKeepingServices.getNote(id));
    }

}
