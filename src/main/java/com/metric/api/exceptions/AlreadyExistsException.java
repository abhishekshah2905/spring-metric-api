package com.metric.api.exceptions;

import com.metric.api.models.common.Error;
import lombok.Getter;

@Getter
public class AlreadyExistsException extends BaseException {
    private final Error error;

    public AlreadyExistsException(String message, Error error) {
        super(message);
        this.error = error;
    }
}
