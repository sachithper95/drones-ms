package com.musalasoft.musalasoftdronetask.service;


import com.musalasoft.musalasoftdronetask.dto.BatteryPercentageDto;
import com.musalasoft.musalasoftdronetask.dto.DroneDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.model.Medication;

import java.util.List;

public interface DroneService {

    /**
     * Get all the available drones.
     *
     * @return A list containing the drones.
     */
    List<Drone> getDroneList();

    /**
     * Get drone details by serial number.
     *
     * @param serialNumber The serial number of a drone.
     * @return The drone details with the corresponding serial number.
     * @throws DroneClientException Throws an exception if an error occurs while getting a drone using serial number.
     */
    Drone getDroneBySerialNumber(String serialNumber) throws DroneClientException;

    /**
     * Register a drone in the system.
     *
     * @param droneDto The DroneDTO.
     * @return A Drone object.
     * @throws DroneClientException Throws an exception if an error occurs while registering a drone.
     */
    Drone registerDrone(DroneDto droneDto) throws DroneClientException;

    /**
     * Get all available drones for loading.
     *
     * @return A list of drones available for LOADING.
     * @throws DroneClientException Throws an exception if an error occurs while getting all the available drones for LOADING.
     */
    List<Drone> getAllAvailableDronesForLoading() throws DroneClientException;

    /**
     * Get Battery Capacity of a drone.
     *
     * @param serialNumber Serial number of a drone.
     * @return BatteryPercentageDto object.
     * @throws DroneClientException Throws an exception if an error occurs while getting battery capacity of a drone.
     */
    BatteryPercentageDto getBatteryPercentageBySerialNumber(String serialNumber) throws DroneClientException;

    /**
     * List of medications of a given drone.
     *
     * @param serialNumber Serial number of the drone.
     * @return List of medications.
     * @throws DroneClientException Throws an exception if an error occurs while getting medication list.
     */
    List<Medication> getMedicationsByDroneSerial(String serialNumber) throws DroneClientException;

}
