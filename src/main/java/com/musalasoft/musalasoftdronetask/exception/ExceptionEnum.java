package com.musalasoft.musalasoftdronetask.exception;

public enum ExceptionEnum {


    DRONE_NOT_FOUND(1204,"Drone not found"),
    INVALID_SERIAL_NUMBER_ERROR(1205,"Invalid Serial number. Maximum 100 characters allowed"),
    INVALID_BATTERY_PERCENTAGE_ERROR(1206,"Invalid batter percentage. battery percentage should be >= 1 and <= 100"),
    INVALID_MAXIMUM_WEIGHT_ERROR(1207,"Invalid Maximum Weight. Maximum weight should be 500"),
    INVALID_DRONE_MODEL_ERROR(1208,"Invalid Drone Model"),
    DRONE_ALREADY_EXISTS_ERROR(1209,"Drone already exists"),
    INVALID_MEDICATION_NAME_ERROR(1210,"Invalid medication name"),
    INVALID_MEDICATION_CODE_ERROR(1211,"Invalid medication code"),
    INVALID_MEDICATION_WEIGHT(1212,"Invalid weight. Weight should be a positive number"),

    INVALID_SERIAL_NUMBER_FOR_MEDICATION_ERROR(1213,"Invalid serial number"),
    DRONE_NOT_AVAILABLE_FOR_LOADING_ERROR(1214,"Drone is not available for loading"),
    LOW_BATTERY_ERROR(1215,"Battery level must be greater than 25 to load the medications"),
    DRONE_WEIGHT_LIMIT_EXCEEDED_ERROR(1216,"Drone weight limit exceeded"),
    INVALID_IMAGE_FILE_ERROR(1220,"Invalid image size"),
    SERIAL_NUMBER_NOT_EXISTS(1217, "Serial number ot exists.");
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
