package com.epam.randomWalk.exception.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ApiException {

    private final String massage;
    private final HttpStatus httpstatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ApiException(String massage, HttpStatus httpstatus, LocalDateTime timestamp) {
        this.massage = massage;
        this.httpstatus = httpstatus;
        this.timestamp = timestamp;
    }

    public String getMassage() {
        return massage;
    }


    public HttpStatus getHttpstatus() {
        return httpstatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

