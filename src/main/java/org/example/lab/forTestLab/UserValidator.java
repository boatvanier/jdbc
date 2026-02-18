package org.example.lab.forTestLab;

public class UserValidator {
    public boolean isValidUsername(String username) {
        if (username == null) return false;
        return username.length() >= 5;
    }
    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("User must be at least 18");
        }
    }
}