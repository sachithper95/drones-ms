package com.musalasoft.musalasoftdronetask.enums;

public enum DroneModel {
    LIGHTWEIGHT("LIGHTWEIGHT"),
    MIDDLEWEIGHT("MIDDLEWEIGHT"),
    CRUISERWEIGHT("CRUISERWEIGHT"),
    HEAVYWEIGHT("HEAVYWEIGHT");

    private final String value;

    DroneModel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
