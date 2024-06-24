package com.vehicles.tutorial.vehicles;

import com.vehicles.tutorial.vehicletype.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {

    @Autowired
    private VehiclesRepository vehicleRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public ArrayList<Vehicles> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicles> getVehicleById(UUID id) {
        return vehicleRepository.findById(id);
    }

    public void saveVehicle(Vehicles vehicles) {
        vehicles.setVehicleId(UUID.randomUUID());
        vehicleRepository.save(vehicles);
    }

    public void updateVehicle(Vehicles vehicles) {
         vehicleRepository.update(vehicles);
    }

    public void deleteVehicle(UUID id) {
        vehicleRepository.delete(id);
    }
}
