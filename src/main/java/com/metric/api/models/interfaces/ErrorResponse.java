package com.metric.api.models.interfaces;

import com.metric.api.models.common.Error;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    private int code;
    private String developersMessage;
    private List<Error> errors;
}