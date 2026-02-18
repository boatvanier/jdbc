package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 3;
        int result = calculator.add(a,b);
        assertEquals(a+b, result);
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(6,4));
    }
}
