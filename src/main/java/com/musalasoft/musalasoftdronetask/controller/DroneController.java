package com.musalasoft.musalasoftdronetask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musalasoft.musalasoftdronetask.dto.DroneDto;
import com.musalasoft.musalasoftdronetask.dto.MedicationDto;
import com.musalasoft.musalasoftdronetask.exception.DroneClientException;
import com.musalasoft.musalasoftdronetask.exception.ExceptionEnum;
import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.service.DroneService;
import com.musalasoft.musalasoftdronetask.service.MedicationService;
import com.musalasoft.musalasoftdronetask.util.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/drone-api/v1/drone")
@RequiredArgsConstructor
public class DroneController {

    private final DroneService droneService;
    private final MedicationService medicationService;

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

    @GetMapping(path = "/loading-availability")
    public ResponseEntity<Object> getAllAvailableDronesForLoading() {
        try {
            return ResponseEntity.ok(droneService.getAllAvailableDronesForLoading());
        } catch (DroneClientException ex) {
            return ErrorHandler.handleClientError(ex);
        }
    }

    @GetMapping(path = "/battery/{serialNumber}")
    public ResponseEntity<Object> getBatteryPercentage(@PathVariable String serialNumber) {
        try {
            return ResponseEntity.ok(droneService.getBatteryPercentageBySerialNumber(serialNumber));
        } catch (DroneClientException ex) {
            return ErrorHandler.handleClientError(ex);
        }
    }

    @PostMapping(path = "/add-medication", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> addMedication(@RequestPart("file") MultipartFile file,
                                                @RequestPart("medication") String medication) throws IOException {

        try {
            if (file == null) {
                ErrorHandler.handleClientError(ErrorHandler.handleException(ExceptionEnum.INVALID_IMAGE_FILE_ERROR));
            }
            Byte[] img = ArrayUtils.toObject(file.getBytes());
            ObjectMapper objectMapper = new ObjectMapper();
            MedicationDto medicationDto = objectMapper.readValue(medication, MedicationDto.class);
            return ResponseEntity.ok(medicationService.addMedication(medicationDto, img));
        } catch (DroneClientException ex) {
            return ErrorHandler.handleClientError(ex);
        }
    }

    @GetMapping("/medications/{serialNumber}")
    public ResponseEntity<Object> getMedicationsByDroneSerial(@PathVariable String serialNumber) {
        try {
            return ResponseEntity.ok(droneService.getMedicationsByDroneSerial(serialNumber));
        } catch (DroneClientException ex) {
            return ErrorHandler.handleClientError(ex);
        }
    }

}
