package com.musalasoft.musalasoftdronetask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musalasoft.musalasoftdronetask.enums.DroneModel;
import com.musalasoft.musalasoftdronetask.enums.DroneState;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "drone")
public class Drone {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Long id;

    @Column(name = "serial_number", length = 100)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "model")
    private DroneModel droneModel;

    @Column(name = "maximum_weight")
    private int weightLimit;

    @JsonProperty("battery")
    @Column(name = "battery_percentage")
    private int batteryPercentage;

    @JsonProperty("state")
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private DroneState droneState;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drone")
    private List<Medication> medicationList;
}
