package com.leonid.eurowings.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DateTimeParseException.class})
    protected ResponseEntity<String> handleException(DateTimeParseException ex, WebRequest request) {

        String bodyOfResponse = "It seems that the date was malformed and could not be parsed: \n" + ex.getMessage();

        return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);

    }
}
