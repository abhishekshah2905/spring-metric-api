package com.metric.api.exceptions;

import com.metric.api.models.common.Error;
import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {
    private final Error error;

    public NotFoundException(String message, Error error) {
        super(message);
        this.error = error;
    }
}
