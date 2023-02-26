package com.musalasoft.musalasoftdronetask.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DroneClientException extends DroneException {

    private String message;
    private int code;
    public DroneClientException(String message, int code) {
        super(message, code);
        this.message = message;
        this.code = code;

    }
}
