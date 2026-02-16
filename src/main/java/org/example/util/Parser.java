package org.example.util;

public class Parser {
    public int parseAge(String ageStr) {
        try {
            return Integer.parseInt(ageStr);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid age: " + ageStr);
        }
    }
}
