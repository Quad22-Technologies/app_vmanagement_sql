package com.vehicles.tutorial.vehicletype;

import java.util.UUID;

public class VehicleType {
    private UUID vehicleTypeId;
    private String typeName;

    public VehicleType() {
    }

    public VehicleType(UUID vehicleTypeId, String typeName) {
        this.vehicleTypeId = vehicleTypeId;
        this.typeName = typeName;
    }

    public UUID getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(UUID vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
