package org.example.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    private Parser parser;
    @BeforeEach
    void setup() {
        parser = new Parser();
    }
    @AfterEach
    void tearDown() {
        parser = null;
    }

    @Test
    void testParseAge_ValidNumber() {
        assertEquals(25, parser.parseAge("25"));
    }

    @Test
    void testParseAge_InvalidNumber() {
        IllegalArgumentException exception
                = assertThrows(IllegalArgumentException.class,
                ()->parser.parseAge("fdsfs"));
        assertTrue(exception.getMessage().contains("invalid age"));
    }

    @Test
    void testParseAge_NegativeNumber() {
        IllegalArgumentException exception
                = assertThrows(IllegalArgumentException.class,
                ()->parser.parseAge("-5"));
        assertTrue(exception.getMessage().contains("invalid age"));
    }
}
