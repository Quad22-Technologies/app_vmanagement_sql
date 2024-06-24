package com.vehicles.tutorial.vehicletype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicletypes")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<ArrayList<VehicleType>> getAllVehicleTypes() {
        ArrayList<VehicleType> vehicleTypes = vehicleTypeService.getAllVehicleTypes();
        return new ResponseEntity<>(vehicleTypes, HttpStatus.OK);
    }

    @RequestMapping(value="/getbyId/{id}", method= RequestMethod.GET)
    public ResponseEntity<VehicleType> getVehicleTypeById(@PathVariable UUID id) {
        Optional<VehicleType> vehicleType = vehicleTypeService.getVehicleTypeById(id);
        return vehicleType.map(type -> new ResponseEntity<>(type, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<VehicleType> createVehicleType(@RequestBody VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);
        return new ResponseEntity<>(vehicleType, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method= RequestMethod.PUT)
    public ResponseEntity<VehicleType> updateVehicleType(@PathVariable UUID id, @RequestBody VehicleType vehicleType) {
        vehicleType.setVehicleTypeId(id);
        vehicleTypeService.updateVehicleType(vehicleType);
        return new ResponseEntity<>(vehicleType, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVehicleType(@PathVariable UUID id) {
        vehicleTypeService.deleteVehicleType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
