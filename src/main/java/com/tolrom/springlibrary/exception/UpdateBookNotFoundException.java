package com.tolrom.springlibrary.exception;

public class UpdateBookNotFoundException extends RuntimeException {
    public UpdateBookNotFoundException(Long id) {
        super("The book with id : " + id + " doesn't exist");
    }
}
