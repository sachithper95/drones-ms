package com.musalasoft.musalasoftdronetask.repository;

import com.musalasoft.musalasoftdronetask.model.Drone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Drone Repository.
 */

public interface DroneRepository extends CrudRepository<Drone, Long> {
    Optional<Drone> findBySerialNumber(String serialNumber);

    @Query(value = "SELECT * FROM drone WHERE state = 'IDLE' OR state = 'LOADING'", nativeQuery = true)
    Optional<List<Drone>> getAvailableDronesForLoading();
}
