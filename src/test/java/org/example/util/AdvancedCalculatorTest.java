package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvancedCalculatorTest {
    @Test
    void addAndDoubleTest(){
        Calculator calculator = mock(Calculator.class);
        when(calculator.add(2,3)).thenReturn(8);

        AdvancedCalculator advancedCalculator = new AdvancedCalculator(calculator);

        assertEquals(16, advancedCalculator.addAndDouble(2,3));
    }
}
