package com.tolrom.springlibrary.exception;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String title) {
        super("The " + title + " book already exists");
    }
}
