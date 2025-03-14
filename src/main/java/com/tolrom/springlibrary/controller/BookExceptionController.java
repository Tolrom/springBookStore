package com.tolrom.springlibrary.controller;

import com.tolrom.springlibrary.exception.BookAlreadyExistsException;
import com.tolrom.springlibrary.exception.BookNotFoundException;
import com.tolrom.springlibrary.exception.NoBookFoundException;
import com.tolrom.springlibrary.exception.UpdateBookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BookExceptionController {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, String>> bookNotFound(BookNotFoundException bookNotFound) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", bookNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoBookFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noBooks(NoBookFoundException noBookFound) {
        return noBookFound.getMessage();
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> bookAlreadyExists(BookAlreadyExistsException bookAlreadyExists) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", bookAlreadyExists.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(UpdateBookNotFoundException.class)
    public ResponseEntity<Map<String, String>> updateBookNotFound(BookNotFoundException bookNotFound) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", bookNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

}