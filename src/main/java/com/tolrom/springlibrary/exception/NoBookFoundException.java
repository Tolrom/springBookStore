package com.tolrom.springlibrary.exception;

public class NoBookFoundException extends RuntimeException {
    public NoBookFoundException() {
        super("No book in the database");
    }
}
