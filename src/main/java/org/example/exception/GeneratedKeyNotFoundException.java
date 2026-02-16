package org.example.exception;

public class GeneratedKeyNotFoundException extends RuntimeException{
    public GeneratedKeyNotFoundException(String entity) {
        super("Failed to get "+entity+ " ID.");
    }
}
