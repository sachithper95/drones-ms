package com.musalasoft.musalasoftdronetask.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "code")
    private String code;

    @Lob
    @Column(name = "img")
    private Byte[] image;
    @ManyToOne()
    private Drone drone;
}
