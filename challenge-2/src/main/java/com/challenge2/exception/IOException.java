package com.challenge2.exception;

public class IOException extends RuntimeException {
    public IOException(String message, Throwable cause) {
        super(message, cause);
    }
}