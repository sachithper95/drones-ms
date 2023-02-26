package com.musalasoft.musalasoftdronetask.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ErrorDto {

    private int code;
    private String message;

    public ErrorDto(){

    }

    public ErrorDto(int code,String message){
        this.code = code;
        this.message = message;
    }
}
