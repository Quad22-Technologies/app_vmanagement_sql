package com.vehicles.tutorial.vehicles;

import com.vehicles.tutorial.vehicletype.VehicleType;

import java.util.UUID;

public class Vehicles {
    private UUID vehicleId;
    private String make;
    private String model;
    private int year;

    private UUID vehicleTypeId;

    private UUID dealerId;

    public Vehicles() {
    }

    public Vehicles(String make, String model, int year, UUID vehicleTypeId, UUID dealerId) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vehicleTypeId = vehicleTypeId;
        this.dealerId = dealerId;
    }

    public Vehicles(UUID vehicleId, String make, String model, int year, UUID vehicleTypeId, UUID dealerId) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.vehicleTypeId = vehicleTypeId;
        this.dealerId = dealerId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public UUID getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(UUID vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public UUID getDealerId() {
        return dealerId;
    }

    public void setDealerId(UUID dealerId) {
        this.dealerId = dealerId;
    }

    public void add(Vehicles vehicles) {
    }
}