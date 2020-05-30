package com.epam.randomWalk.exception.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        ApiException apiException = new ApiException(e.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MissingServletRequestParameterException.class })
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException e) {
        String missingParamName = String.format("Missing the %s param", e.getParameterName());
        ApiException apiException = new ApiException(missingParamName,
                HttpStatus.UNPROCESSABLE_ENTITY,
                LocalDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleApiRequestArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String errorMessage = String.format("Variable should be type of %s", e.getRequiredType().getName());
        ApiException apiException = new ApiException(errorMessage,
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}