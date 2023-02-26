package com.musalasoft.musalasoftdronetask.service;

import com.musalasoft.musalasoftdronetask.dto.MedicationDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.model.Medication;

public interface MedicationService {

    /**
     * Add medication.
     *
     * @param medicationDto The MedicationDTO.
     * @return A Medication Object.
     * @throws DroneClientException Throws an exception if an error occurs while adding a medication.
     */
    Medication addMedication(MedicationDto medicationDto, Byte[] img) throws DroneClientException;
}
