package com.musalasoft.musalasoftdronetask.util;

import com.musalasoft.musalasoftdronetask.dto.ErrorDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.exception.DroneNotFoundException;
import com.musalasoft.musalasoftdronetask.exception.ExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandler {
    public static ResponseEntity<Object> handleClientError(DroneClientException e) {

        if(e.getCode() == ExceptionEnum.DRONE_NOT_FOUND.getErrorCode()){
            return new ResponseEntity<>(new ErrorDto(e.getCode(),e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ErrorDto(e.getCode(),e.getMessage()), HttpStatus.BAD_REQUEST);

    }
    public static DroneClientException handleException(ExceptionEnum exceptionEnum){
        return new DroneClientException(exceptionEnum.getErrorMessage(),exceptionEnum.getErrorCode());
    }
}
