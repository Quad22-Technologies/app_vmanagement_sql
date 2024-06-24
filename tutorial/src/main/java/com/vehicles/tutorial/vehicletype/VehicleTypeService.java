package com.vehicles.tutorial.vehicletype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public ArrayList<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public Optional<VehicleType> getVehicleTypeById(UUID id) {
        return vehicleTypeRepository.findById(id);
    }

    public void saveVehicleType(VehicleType vehicleType) {
        vehicleType.setVehicleTypeId(UUID.randomUUID());
        vehicleTypeRepository.save(vehicleType);
    }

    public void updateVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.update(vehicleType);
    }

    public void deleteVehicleType(UUID id) {
        vehicleTypeRepository.delete(id);
    }
}
