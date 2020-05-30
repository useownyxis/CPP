package com.epam.randomWalk.exception.internal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class InternalExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    public ResponseEntity<Object> handleArithmeticException(InternalError e) {

        InternalException arithmeticException = new InternalException(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now());
        return new ResponseEntity<>(arithmeticException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
