package com.vehicles.tutorial.vehicletype;
import org.springframework.stereotype.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public class VehicleTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<VehicleType> vehicleTypeRowMapper = new RowMapper<VehicleType>() {
        @Override
        public VehicleType mapRow(ResultSet rs, int rowNum) throws SQLException {
            VehicleType vehicleType = new VehicleType();
            vehicleType.setVehicleTypeId(UUID.fromString(rs.getObject("vehicleTypeId", UUID.class).toString()));
            vehicleType.setTypeName(rs.getString("typeName"));
            return vehicleType;
        }
    };

    public ArrayList<VehicleType> findAll() {
        String sql = "SELECT * FROM VehicleTypes";
        return (ArrayList<VehicleType>) jdbcTemplate.query(sql, vehicleTypeRowMapper);
    }

    public Optional<VehicleType> findById(UUID id) {
        String sql = "SELECT * FROM VehicleTypes WHERE vehicleTypeId = ?";
        VehicleType vehicleType = jdbcTemplate.queryForObject(sql, new Object[]{id}, vehicleTypeRowMapper);
        return Optional.ofNullable(vehicleType);
    }

    public void save(VehicleType vehicleType) {
        String sql = "INSERT INTO VehicleTypes (vehicleTypeId, typeName) VALUES (?, ?)";
        jdbcTemplate.update(sql, vehicleType.getVehicleTypeId(), vehicleType.getTypeName());
    }

    public void update(VehicleType vehicleType) {
        String sql = "UPDATE VehicleTypes SET typeName = ? WHERE vehicleTypeId = ?";
        jdbcTemplate.update(sql, vehicleType.getTypeName(), vehicleType.getVehicleTypeId());
    }

    public void delete(UUID id) {
        String sql = "DELETE FROM VehicleTypes WHERE vehicleTypeId = ?";
        jdbcTemplate.update(sql, id);
    }
}