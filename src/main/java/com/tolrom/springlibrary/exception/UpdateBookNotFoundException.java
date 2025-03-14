package com.tolrom.springlibrary.exception;

public class UpdateBookNotFoundException extends RuntimeException {
  public UpdateBookNotFoundException(String message) {
    super(message);
  }
}
