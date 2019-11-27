package com.jth.spring.vehicle;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcVehicleDao implements VehicleDao {

    private static final String INSERT_SQL = "INSERT INTO vehicle.vehicle(COLOR, WHEEL, SEAT, VEHICLE_NO) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE vehicle.vehicle SET COLOR=?, WHEEL=?, SEAT=?, WHERE VEHICLE_NO=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM vehicle.vehicle";
    private static final String SELECT_ONE_SQL = "SELECT * FROM vehicle.vehicle WHERE VEHICLE_NO = ?";
    private static final String DELETE_SQL = "DELETE FROM vehicle.vehicle WHERE VEHICLE_NO=?";
    private static final String COUNT_ALL_SQL = "SELECT COUNT(*) FROM vehicle.vehicle";
    private static final String SELECT_COLOR_SQL = "SELECT COLOR FROM vehicle.vehicle WHERE VEHICLE_NO=?";

    private final JdbcTemplate jdbcTemplate;

    public JdbcVehicleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Vehicle vehicle) {
        jdbcTemplate.update(INSERT_SQL, vehicle.getColor(), vehicle.getWheel(), vehicle.getSeat(), vehicle.getVehicleNo());
    }

    @Override
    public void insert(Collection<Vehicle> vehicles) {
        jdbcTemplate.batchUpdate(INSERT_SQL, vehicles, vehicles.size(), this::prepareStatement);
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        return jdbcTemplate.queryForObject(SELECT_ONE_SQL, BeanPropertyRowMapper.newInstance(Vehicle.class), vehicleNo);
    }

    @Override
    public List<Vehicle> findAll() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_SQL);
        return rows.stream().map(row -> {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo((String) row.get("VEHICLE_NO"));
            vehicle.setColor((String) row.get("COLOR"));
            vehicle.setWheel((Integer) row.get("WHEEL"));
            vehicle.setSeat((Integer) row.get("SEAT"));
            return vehicle;
        }).collect(Collectors.toList());
    }

    private Vehicle toVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(rs.getString("VEHICLE_NO"),
                rs.getString("COLOR"), rs.getInt("WHEEL"),
                rs.getInt("SEAT"));
    }

    private void prepareStatement(PreparedStatement ps, Vehicle vehicle) throws SQLException {
        ps.setString(1, vehicle.getColor());
        ps.setInt(2, vehicle.getWheel());
        ps.setInt(3, vehicle.getSeat());
        ps.setString(4, vehicle.getVehicleNo());
    }

    @Override
    public void update(Vehicle vehicle) {
        jdbcTemplate.update(UPDATE_SQL, ps -> prepareStatement(ps, vehicle));
    }

    @Override
    public void delete(Vehicle vehicle) {
        jdbcTemplate.update(DELETE_SQL, vehicle.getVehicleNo());
    }

    private class VehicleRowMapper implements RowMapper<Vehicle> {
        @Override
        public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return toVehicle(rs);
        }
    }

    @Override
    public String getColor(String vehicleNo) {
        return jdbcTemplate.queryForObject(SELECT_COLOR_SQL, String.class, vehicleNo);
    }

    @Override
    public int countAll() {
        return jdbcTemplate.queryForObject(COUNT_ALL_SQL, Integer.class);
    }
}