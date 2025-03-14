package com.tolrom.springlibrary.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("The book with id : " + id + " doesn't exist");
    }
}
