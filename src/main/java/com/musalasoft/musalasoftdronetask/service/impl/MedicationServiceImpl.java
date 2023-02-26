package com.musalasoft.musalasoftdronetask.service.impl;

import com.musalasoft.musalasoftdronetask.dto.MedicationDto;
import com.musalasoft.musalasoftdronetask.enums.DroneState;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.exception.ExceptionEnum;
import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.model.Medication;
import com.musalasoft.musalasoftdronetask.repository.DroneRepository;
import com.musalasoft.musalasoftdronetask.repository.MedicationRepository;
import com.musalasoft.musalasoftdronetask.service.MedicationService;
import com.musalasoft.musalasoftdronetask.util.Constants;
import com.musalasoft.musalasoftdronetask.util.ErrorHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;
    private final DroneRepository droneRepository;

    @Override
    public Medication addMedication(MedicationDto medicationDto, Byte[] img) throws DroneClientException {

        if (!medicationDto.getName().matches(Constants.REGEX)) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_MEDICATION_NAME_ERROR);
        }

        if (!medicationDto.getCode().matches(Constants.REGEX)) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_MEDICATION_CODE_ERROR);
        }

        if (medicationDto.getWeight() < 0) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_MEDICATION_WEIGHT);
        }

        Optional<Drone> optional = droneRepository.findBySerialNumber(medicationDto.getDroneSerialNumber());
        Drone drone = null;

        if (optional.isPresent()) {
            drone = optional.get();
        }

        if (drone == null) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_SERIAL_NUMBER_FOR_MEDICATION_ERROR);
        }

        if (!drone.getDroneState().getValue().equalsIgnoreCase(DroneState.IDLE.getValue()) && !drone.getDroneState().getValue().equalsIgnoreCase(DroneState.LOADING.getValue())) {
            throw ErrorHandler.handleException(ExceptionEnum.DRONE_NOT_AVAILABLE_FOR_LOADING_ERROR);
        }

        if (drone.getBatteryPercentage() < Constants.MINIMUM_BATTERY_PERCENTAGE) {
            throw ErrorHandler.handleException(ExceptionEnum.LOW_BATTERY_ERROR);
        }

        int diff = drone.getWeightLimit() - medicationDto.getWeight();
        if (diff < 0) {
            throw ErrorHandler.handleException(ExceptionEnum.DRONE_WEIGHT_LIMIT_EXCEEDED_ERROR);
        }

        drone.setDroneState(diff > 0 ? DroneState.LOADING : DroneState.LOADED);
        drone.setWeightLimit(diff);

        droneRepository.save(drone);

        Medication medication = new Medication();
        BeanUtils.copyProperties(medicationDto, medication);
        medication.setImage(img);
        medication.setDrone(drone);
        medicationRepository.save(medication);

        return medication;
    }
}
