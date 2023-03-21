package com.west.prime.exception;

import com.west.prime.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleInvalidInputException(InvalidInputException message) {

        return new Error(HttpStatus.BAD_REQUEST.value(), message.getMessage());
    }

}
