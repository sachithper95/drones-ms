package com.musalasoft.musalasoftdronetask.service;

import com.musalasoft.musalasoftdronetask.dto.MedicationDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.model.Medication;

public interface MedicationService {

    Medication addMedication(MedicationDto medicationDto, Byte[] img)throws DroneClientException;
}
