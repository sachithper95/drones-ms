package com.musalasoft.musalasoftdronetask.controller;


import com.musalasoft.musalasoftdronetask.dto.BatteryPercentageDto;
import com.musalasoft.musalasoftdronetask.enums.DroneModel;
import com.musalasoft.musalasoftdronetask.enums.DroneState;
import com.musalasoft.musalasoftdronetask.model.Drone;
import com.musalasoft.musalasoftdronetask.service.DroneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class DroneControllerTest {

    @Mock
    DroneService droneService;

    @InjectMocks
    DroneController droneController;

    MockMvc mockMvc;

    List<Drone> droneList;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(droneController).build();
        droneList = new ArrayList<>();
        Drone drone = new Drone();
        drone.setId(1L);
        drone.setDroneModel(DroneModel.LIGHTWEIGHT);
        drone.setDroneState(DroneState.DELIVERED);
        drone.setBatteryPercentage(50);
        drone.setSerialNumber("D360");
        drone.setWeightLimit(100);
        droneList.add(drone);
    }

    @Test
    void testGetAllDrone() throws Exception {
        when(droneService.getDroneList()).thenReturn(this.droneList);
        mockMvc.perform(get("/drone-api/v1/drone")).andExpect(status().isOk());
    }
    @Test
    void testGetDroneBySerialNumber() throws Exception {
        Drone drone = new Drone();
        drone.setId(1L);
        drone.setDroneModel(DroneModel.LIGHTWEIGHT);
        drone.setDroneState(DroneState.DELIVERED);
        drone.setBatteryPercentage(50);
        drone.setSerialNumber("D360");
        drone.setWeightLimit(100);

        when(droneService.getDroneBySerialNumber("D360")).thenReturn(drone);
        mockMvc.perform(get("/drone-api/v1/drone/D360")).andExpect(status().isOk());
    }

    @Test
    void testGetBatteryPercentageByDroneSerialNumber() throws Exception {
        BatteryPercentageDto batteryPercentageDto = new BatteryPercentageDto();
        batteryPercentageDto.setBatteryPercentage(60);
        batteryPercentageDto.setSerialNumber("D360");
        when(droneService.getBatteryPercentageBySerialNumber("D360")).thenReturn(batteryPercentageDto);
        mockMvc.perform(get("/drone-api/v1/drone/battery/D360")).andExpect(status().isOk());
    }

}
