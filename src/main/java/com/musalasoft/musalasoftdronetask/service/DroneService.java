package com.musalasoft.musalasoftdronetask.service;


import com.musalasoft.musalasoftdronetask.dto.DroneDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.exception.DroneNotFoundException;
import com.musalasoft.musalasoftdronetask.model.Drone;

import java.util.List;

public interface DroneService {
    List<Drone> getDroneList();

    Drone getDroneBySerialNumber(String serialNumber) throws DroneClientException;

    Drone registerDrone(DroneDto droneDto) throws DroneClientException;

    List<Drone> getAllAvailableDronesForLoading() throws DroneClientException;

}
