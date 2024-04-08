package com.metric.api.exceptions;

public abstract class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}
