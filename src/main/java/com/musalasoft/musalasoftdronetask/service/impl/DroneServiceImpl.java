package com.musalasoft.musalasoftdronetask.service.impl;

import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.repository.DroneRepository;
import com.musalasoft.musalasoftdronetask.service.DroneService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    @Override
    public List<Drone> getDroneList() {
        return IterableUtils.toList(droneRepository.findAll());
    }
}
