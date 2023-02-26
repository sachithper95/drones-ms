package com.musalasoft.musalasoftdronetask.controller;

import com.musalasoft.musalasoftdronetask.dto.DroneDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.exception.DroneNotFoundException;
import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.service.DroneService;
import com.musalasoft.musalasoftdronetask.util.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/drone-api/v1/drone")
@RequiredArgsConstructor
public class DroneController {

    private final DroneService droneService;

    @GetMapping
    public ResponseEntity<List<Drone>> getAllDroneList() {
        return ResponseEntity.ok(droneService.getDroneList());
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<Object> getDroneBySerialNumber(@PathVariable String serialNumber) {
        try {
            return ResponseEntity.ok(droneService.getDroneBySerialNumber(serialNumber));
        } catch (DroneClientException ex) {
            return ErrorHandler.handleClientError(ex);
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerDrone(@RequestBody @Valid DroneDto drone) {
        try {
            return ResponseEntity.ok(droneService.registerDrone(drone));
        } catch (DroneClientException ex) {
            return ErrorHandler.handleClientError(ex);
        }
    }
}
