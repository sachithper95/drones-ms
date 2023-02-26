package com.musalasoft.musalasoftdronetask.enums;

public enum DroneState {
    IDLE("IDLE"),
    LOADING("LOADING"),
    LOADED("LOADED"),
    DELIVERING("DELIVERING"),
    DELIVERED("DELIVERED"),
    RETURNING("RETURNING");

    private final String value;

    DroneState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
