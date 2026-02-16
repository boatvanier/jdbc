package org.example.exception;

public class SQLDataAccessException extends RuntimeException{
    public SQLDataAccessException (String message) {
        super(message);
    }
}
