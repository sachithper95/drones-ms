package com.musalasoft.musalasoftdronetask.exception;

public class DroneNotFoundException extends DroneException {

    public DroneNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }
    public DroneNotFoundException(String message, String description, int errorCode) {
        super(message, description, errorCode);
    }
    public DroneNotFoundException(String message, String description, int errorCode, Throwable cause){
        super(message, description, errorCode, cause);
    }
}
