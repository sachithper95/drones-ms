package com.musalasoft.musalasoftdronetask.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Medication model.
 */
@Entity
@Data
@Table(name = "medication")
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
