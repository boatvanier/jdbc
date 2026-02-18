package org.example.util;

public class Calculator {
    public int add(int a, int b) {
        //return a+b;
        return 0;
    }
    public int subtract(int a, int b) {
        return a-b;
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public int addAndDouble(int a, int b) {
        int sum = add(a,b);
        return sum*2;
    }

}
