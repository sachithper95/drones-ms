package com.musalasoft.musalasoftdronetask.repository;

import com.musalasoft.musalasoftdronetask.model.Drone;
import org.springframework.data.repository.CrudRepository;

public interface DroneRepository extends CrudRepository<Drone, Long> {
}
