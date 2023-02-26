package com.musalasoft.musalasoftdronetask.exception;

public enum ExceptionEnum {


    DRONE_NOT_FOUND(1204,"Drone not found"),
    INVALID_SERIAL_NUMBER_ERROR(1205,"Invalid Serial number. Maximum 100 characters allowed"),
    INVALID_BATTERY_PERCENTAGE_ERROR(1206,"Invalid batter percentage. battery percentage should be >= 1 and <= 100"),
    INVALID_MAXIMUM_WEIGHT_ERROR(1207,"Invalid Maximum Weight. Maximum weight should be 500"),
    INVALID_DRONE_MODEL_ERROR(1208,"Invalid Drone Model"),
    DRONE_ALREADY_EXISTS_ERROR(1209,"Drone already exists");
    private int errorCode;
    private String errorMessage;

    ExceptionEnum(int errorCode, String errorMessage ) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
