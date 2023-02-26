package com.musalasoft.musalasoftdronetask.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DroneDto {
    private String serialNumber;
    private String model;
    private int maximumWeight;
    private int batteryPercentage;
}
