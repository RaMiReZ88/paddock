package com.example.paddock.utils.handler;

import com.example.paddock.controller.Response;
import com.example.paddock.exception.request.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response> handleException(BadRequestException exception) {
        return new ResponseEntity<>(Response.builder()
                .error(exception.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
