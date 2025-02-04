package com.junitAssignment.junitAssignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class StringReverserTest {

    @Test
    public void testString1(){
        assertEquals("42SRAC" , StringReverser.reverse("CARS24"));
    }

    @Test
    public void testString2(){
        assertEquals("NIF 42SRAC" , StringReverser.reverse("CARS24 FIN"));
    }

    @Test
    public void testString3(){
        assertEquals("" , StringReverser.reverse(""));
    }

    @Test
    void testReverseNullString() {
        assertNull(StringReverser.reverse(null));
    }

}
