package com.vehicles.tutorial.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public class VehiclesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Vehicles> vehicleRowMapper = new RowMapper<Vehicles>() {
        @Override
        public Vehicles mapRow(ResultSet rs, int rowNum) throws SQLException {

            Vehicles vehicle = new Vehicles();
            vehicle.setVehicleId(UUID.fromString(rs.getObject("vehicleid", UUID.class).toString()));
            vehicle.setMake(rs.getString("make"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setYear(Integer.parseInt(rs.getString("year")));
            vehicle.setModel(rs.getString("model"));
            vehicle.setVehicleTypeId(UUID.fromString(rs.getObject("vehicletypeid", UUID.class).toString()));
            vehicle.setDealerId(UUID.fromString(rs.getObject("dealerid", UUID.class).toString()));

            return vehicle;
        }
    };

    public ArrayList<Vehicles> findAll() {
        ArrayList<Vehicles> test = (ArrayList<Vehicles>) jdbcTemplate.query("SELECT * FROM vehicles", vehicleRowMapper);
        return test;
    }

    public Optional<Vehicles> findById(UUID id) {
        return jdbcTemplate.query("SELECT * FROM vehicles WHERE vehicleid = ?", new Object[]{id}, vehicleRowMapper).stream().findFirst();
    }

    public void save(Vehicles vehicle) {
        jdbcTemplate.update("INSERT INTO vehicles (vehicle_id, make, model, year, vehicletypeid, dealer_id) VALUES (?, ?, ?, ?, ?, ?)",
                vehicle.getVehicleId(), vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getVehicleTypeId(), vehicle.getDealerId());
    }

    public void update(Vehicles vehicle) {
        jdbcTemplate.update("UPDATE vehicles SET make = ?, model = ?, year = ?, vehicletypeid = ?, dealerid = ? WHERE vehicleid = ?",
                vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getVehicleTypeId(), vehicle.getDealerId(), vehicle.getVehicleId());
    }

    public void delete(UUID id) {
        jdbcTemplate.update("DELETE FROM vehicles WHERE vehicle_id = ?", id);
    }
}
