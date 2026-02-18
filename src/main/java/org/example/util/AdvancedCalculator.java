package org.example.util;

public class AdvancedCalculator {
    private Calculator calculator;

    public AdvancedCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int addAndDouble(int a, int b) {
        int sum = calculator.add(a,b);
        return sum*2;
    }

}
