package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    void testParseAge_ValidNumber() {
        Parser parser = new Parser();
        assertEquals(25, parser.parseAge("25"));
    }

    @Test
    void testParseAge_InvalidNumber() {
        Parser parser = new Parser();
        IllegalArgumentException exception
                = assertThrows(IllegalArgumentException.class,
                ()->parser.parseAge("fdsfs"));
        assertTrue(exception.getMessage().contains("invalid age"));
    }

    @Test
    void testParseAge_NegativeNumber() {
        Parser parser = new Parser();
        IllegalArgumentException exception
                = assertThrows(IllegalArgumentException.class,
                ()->parser.parseAge("-5"));
        assertTrue(exception.getMessage().contains("invalid age"));
    }
}
