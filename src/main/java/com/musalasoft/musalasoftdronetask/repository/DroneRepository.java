package com.musalasoft.musalasoftdronetask.repository;

import com.musalasoft.musalasoftdronetask.model.Drone;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DroneRepository extends CrudRepository<Drone, Long> {
    Optional<Drone> findBySerialNumber(String serialNumber);
}
