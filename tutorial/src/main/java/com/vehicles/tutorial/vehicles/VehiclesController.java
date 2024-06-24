package com.vehicles.tutorial.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {
    @Autowired
    private VehicleService VehicleService;

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<ArrayList<Vehicles>> getAllVehicles() {
        ArrayList<Vehicles> Vehicles = VehicleService.getAllVehicles();
        return new ResponseEntity<>(Vehicles, HttpStatus.OK);
    }

    @RequestMapping(value="/getbyId/{id}", method= RequestMethod.GET)
    public ResponseEntity<Vehicles> getVehiclesById(@PathVariable UUID id) {
        Optional<Vehicles> Vehicles = VehicleService.getVehicleById(id);
        return Vehicles.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<Vehicles> createVehicles(@RequestBody Vehicles Vehicles) {
        VehicleService.saveVehicle(Vehicles);
        return new ResponseEntity<>(Vehicles, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Vehicles> updateVehicles(@PathVariable UUID id, @RequestBody Vehicles Vehicles) {
        Vehicles.setVehicleId(id);
        VehicleService.updateVehicle(Vehicles);
        return new ResponseEntity<>(Vehicles, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVehicles(@PathVariable UUID id) {
        VehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
