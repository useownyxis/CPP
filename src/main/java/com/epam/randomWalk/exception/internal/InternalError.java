package com.epam.randomWalk.exception.internal;

public class InternalError extends ArithmeticException {

    private int exceptionCode;

    public InternalError(String message) {
        super(message);
    }
    public InternalError(String message, int exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }
}
