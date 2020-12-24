package com.example.demo.repository;

import com.example.demo.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarehouseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Warehouse> findAll() {
        List<Warehouse> warehouseList = jdbcTemplate.query("SELECT * FROM warehouse",(response, rowNumber) ->
                new Warehouse(response.getLong("id"),
                        response.getString("adress"),
                        response.getLong("nr_employees")));
        return warehouseList;
    }

    public void createWarehouse(Warehouse warehouse) {
        jdbcTemplate.update("INSERT INTO warehouse(id, adress, nr_employees)\n" +
                "    VALUES (?,?,?)",
                warehouse.getId(),
                warehouse.getAdress(),
                warehouse.getNrEmployees()
                );
    }

    public void save(long id, String adress, int nrEmployees) {
        jdbcTemplate.update("INSERT INTO warehouse(id, adress, nr_employees)\n" +
                        "    VALUES (?,?,?)", id, adress, nrEmployees);
    }

    public void updateWarehouse(long id, Warehouse warehouse) {
        jdbcTemplate.update("UPDATE warehouse SET adress = ? WHERE id = ?)",
                warehouse.getAdress(), id);
    }

    public void deleteWarehouse(long id) {
        jdbcTemplate.update("DELETE FROM warehouse WHERE id = ?", id);
    }
}
