package org.example.controller;

import org.example.service.NoInformationFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public NoInformationFoundException handleNoInformationFoundException(final NoInformationFoundException e) {
        return new NoInformationFoundException(e.getMessage());
    }
}