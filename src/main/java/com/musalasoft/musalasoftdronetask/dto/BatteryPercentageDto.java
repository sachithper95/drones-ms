package com.musalasoft.musalasoftdronetask.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * DTO for Battery Percentage.
 */
@Data
@Component
public class BatteryPercentageDto {
    String serialNumber;
    int batteryPercentage;
}
