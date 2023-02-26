package com.musalasoft.musalasoftdronetask.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * DTO for Medication.
 */
@Data
@Component
public class MedicationDto {
    private String name;
    private int weight;
    private String code;
    private String droneSerialNumber;
}
