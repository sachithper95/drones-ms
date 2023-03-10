package com.musalasoft.musalasoftdronetask.service.impl;

import com.musalasoft.musalasoftdronetask.dto.BatteryPercentageDto;
import com.musalasoft.musalasoftdronetask.dto.DroneDto;
import com.musalasoft.musalasoftdronetask.enums.DroneModel;
import com.musalasoft.musalasoftdronetask.enums.DroneState;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.exception.ExceptionEnum;
import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.model.Medication;
import com.musalasoft.musalasoftdronetask.repository.DroneRepository;
import com.musalasoft.musalasoftdronetask.service.DroneService;
import com.musalasoft.musalasoftdronetask.util.Constants;
import com.musalasoft.musalasoftdronetask.util.ErrorHandler;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    @Override
    public List<Drone> getDroneList() {
        return IterableUtils.toList(droneRepository.findAll());
    }

    @Override
    public Drone getDroneBySerialNumber(String serialNumber) throws DroneClientException {
        Optional<Drone> opt = droneRepository.findBySerialNumber(serialNumber);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw ErrorHandler.handleException(ExceptionEnum.DRONE_NOT_FOUND);
    }

    @Override
    public Drone registerDrone(DroneDto droneDto) throws DroneClientException {
        if (droneDto.getSerialNumber().length() > 100) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_SERIAL_NUMBER_ERROR);
        }
        if (droneDto.getMaximumWeight() > Constants.MAXIMUM_WEIGHT_LIMIT || droneDto.getMaximumWeight() < 0) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_MAXIMUM_WEIGHT_ERROR);
        }
        if (droneDto.getBatteryPercentage() > 100 || droneDto.getBatteryPercentage() <= 0) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_BATTERY_PERCENTAGE_ERROR);
        }

        String model = droneDto.getModel().toUpperCase();

        if (!model.equalsIgnoreCase(DroneModel.HEAVYWEIGHT.getValue()) && !model.equalsIgnoreCase(DroneModel.LIGHTWEIGHT.getValue()) &&
                !model.equalsIgnoreCase(DroneModel.CRUISERWEIGHT.getValue()) && !model.equalsIgnoreCase(DroneModel.MIDDLEWEIGHT.getValue())) {
            throw ErrorHandler.handleException(ExceptionEnum.INVALID_DRONE_MODEL_ERROR);
        }

        Optional<Drone> opt = droneRepository.findBySerialNumber(droneDto.getSerialNumber());
        if (opt.isPresent()) {
            throw ErrorHandler.handleException(ExceptionEnum.DRONE_ALREADY_EXISTS_ERROR);
        }

        Drone drone = new Drone();
        drone.setSerialNumber(droneDto.getSerialNumber());
        drone.setDroneModel(DroneModel.valueOf(droneDto.getModel().toUpperCase()));
        drone.setWeightLimit(droneDto.getMaximumWeight());
        drone.setBatteryPercentage(droneDto.getBatteryPercentage());
        drone.setDroneState(DroneState.IDLE);

        return droneRepository.save(drone);
    }

    @Override
    public List<Drone> getAllAvailableDronesForLoading() throws DroneClientException {
        Optional<List<Drone>> availableDronesForLoading = droneRepository.getAvailableDronesForLoading();
        if (availableDronesForLoading.isPresent()) {
            return availableDronesForLoading.get();
        }
        return Collections.emptyList();
    }

    @Override
    public BatteryPercentageDto getBatteryPercentageBySerialNumber(String serialNumber) throws DroneClientException {
        Optional<Drone> opt = droneRepository.findBySerialNumber(serialNumber);
        if (opt.isPresent()) {
            BatteryPercentageDto batteryPercentageDto = new BatteryPercentageDto();
            Drone drone = opt.get();
            batteryPercentageDto.setSerialNumber(drone.getSerialNumber());
            batteryPercentageDto.setBatteryPercentage(drone.getBatteryPercentage());
            return batteryPercentageDto;
        }
        throw ErrorHandler.handleException(ExceptionEnum.DRONE_NOT_FOUND);
    }

    @Override
    public List<Medication> getMedicationsByDroneSerial(String serialNumber) throws DroneClientException {
        Optional<Drone> bySerialNumber = droneRepository.findBySerialNumber(serialNumber);
        if (bySerialNumber.isPresent()) {
            Drone drone = bySerialNumber.get();
            return drone.getMedicationList();
        }
        throw ErrorHandler.handleException(ExceptionEnum.SERIAL_NUMBER_NOT_EXISTS);
    }
}
