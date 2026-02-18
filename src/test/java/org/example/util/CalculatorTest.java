package org.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        int a = 2;
        int b = 3;
        int result = calculator.add(a,b);
        assertEquals(a+b, result);
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(6,4));
    }

    @ParameterizedTest
    @ValueSource(ints={2,4,6,8})
    void testIsEven_WithEvenNumbers(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints={1,3,5,7})
    void testIsEven_WithOddNumbers(int number) {
        assertFalse(calculator.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
      "2, true",
      "3, false",
      "4, true",
      "5, false"
    })
    void testIsEven_WithCsvSource(int number, boolean expected) {
        assertEquals(expected, calculator.isEven(number));
    }
}
