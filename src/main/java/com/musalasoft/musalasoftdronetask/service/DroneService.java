package com.musalasoft.musalasoftdronetask.service;


import com.musalasoft.musalasoftdronetask.dto.BatteryPercentageDto;
import com.musalasoft.musalasoftdronetask.dto.DroneDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.exception.DroneNotFoundException;
import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.model.Medication;

import java.util.List;

public interface DroneService {
    List<Drone> getDroneList();

    Drone getDroneBySerialNumber(String serialNumber) throws DroneClientException;

    Drone registerDrone(DroneDto droneDto) throws DroneClientException;

    List<Drone> getAllAvailableDronesForLoading() throws DroneClientException;

    BatteryPercentageDto getBatteryPercentageBySerialNumber(String serialNumber) throws DroneClientException;

    List<Medication> getMedicationsByDroneSerial(String serialNumber) throws DroneClientException;

}
