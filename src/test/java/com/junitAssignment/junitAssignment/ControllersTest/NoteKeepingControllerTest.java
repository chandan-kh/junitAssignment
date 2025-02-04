package com.junitAssignment.junitAssignment.ControllersTest;

import com.junitAssignment.junitAssignment.Contollers.NoteKeepingController;
import com.junitAssignment.junitAssignment.Dao.NoteKeepingDao;
import com.junitAssignment.junitAssignment.Requests.AddNoteRequests;
import com.junitAssignment.junitAssignment.Responses.GetResp;
import com.junitAssignment.junitAssignment.Services.impl.NoteKeepingServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


public class NoteKeepingControllerTest {

    @Mock
    private NoteKeepingServicesImpl noteKeepingServices;

    @InjectMocks
    private NoteKeepingController noteKeepingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createNoteTest(){
        AddNoteRequests requests = new AddNoteRequests();
        requests.setUsername("Test");
        requests.setNote("Testing note");

        when(noteKeepingServices.createNote(requests)).thenReturn("Successfully added note");
        String response = noteKeepingController.createNote(requests);
        assertEquals("Successfully added note", response);
    }

    @Test
    void delNoteTest(){
        int id = 1;
        doNothing().when(noteKeepingServices).delNote(id);

        String response = noteKeepingController.delNote(id);
        assertEquals("Deleted id successfully", response);

    }

    @Test
    void updateNoteTest(){
        int id = 1;

        AddNoteRequests requests = new AddNoteRequests();
        requests.setUsername("Test");
        requests.setNote("Testing note");

        when(noteKeepingServices.updateNote(requests,id)).thenReturn("Updated added note");

        String response = noteKeepingController.updateNote(requests,id);

        assertEquals("Updated added note", response);

    }


    @Test
    void testGetNote() {

        int id = 1;
        GetResp mockResponse = new GetResp();
        mockResponse.setId(id);
        mockResponse.setUsername("testUser");
        mockResponse.setNote("Test note content");

        when(noteKeepingServices.getNote(id)).thenReturn(mockResponse);

        ResponseEntity<GetResp> response = noteKeepingController.getNote(id);

        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
        assertEquals("testUser", response.getBody().getUsername());
        assertEquals("Test note content", response.getBody().getNote());

    }



}
