package org.example.service;

public class NoInformationFoundException extends RuntimeException {
    public NoInformationFoundException(String message) {
        super(message);
    }
}
