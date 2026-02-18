package org.example.util;

public class Parser {
    public int parseAge(String ageStr) {
        try {
            int result = Integer.parseInt(ageStr);

            if (result < 0) {
                throw new NumberFormatException();
            }

            return result;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid age: " + ageStr);
        }
    }
}
