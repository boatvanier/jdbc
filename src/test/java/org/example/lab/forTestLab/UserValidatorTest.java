package org.example.lab.forTestLab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    private UserValidator validator = new UserValidator();

    @ParameterizedTest
    @CsvSource({
            "null, false",
            "abc, false",
            "john1, true",
            "username, true"
    })
    void testIsValidUsername(String input, boolean expected) {

        if ("null".equals(input)) {
            input = null;
        }

        assertEquals(expected, validator.isValidUsername(input));
    }

    @Test
    void testValidateAge_whenUnder18() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAge(16));
    }

    @Test
    void testValidateAge_when18OrAbove() {
        assertDoesNotThrow(() -> validator.validateAge(18));
        assertDoesNotThrow(() -> validator.validateAge(25));
    }
}
