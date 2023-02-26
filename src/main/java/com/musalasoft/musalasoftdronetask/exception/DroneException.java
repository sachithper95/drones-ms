package com.musalasoft.musalasoftdronetask.exception;

public class DroneException extends Exception{
    private int code;
    private String description;

    public DroneException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DroneException(String message, int code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public DroneException(String message, String description, int code){
        super(message);
        this.code = code;
        this.description = description;
    }

    public DroneException(String message, String description, int errorCode, Throwable cause){
        super(message, cause);
        this.code = errorCode;
        this.description = description;
    }
}
