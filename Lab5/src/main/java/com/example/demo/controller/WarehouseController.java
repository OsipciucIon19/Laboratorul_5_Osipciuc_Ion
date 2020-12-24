package com.example.demo.controller;

import com.example.demo.entity.Warehouse;
import com.example.demo.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseRepository  warehouseRepository;

    @GetMapping
    public List<Warehouse> findAll() {
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        return warehouseList;
    }

    @PostMapping("/request")
    public void createWarehouse(@RequestBody Warehouse warehouse) {
        warehouseRepository.createWarehouse(warehouse);
    }

    @PostMapping
    public void save(@RequestParam Long id,@RequestParam String adress, @RequestParam int nrEmplyees) {
        warehouseRepository.save(id, adress, nrEmplyees);
    }

    @PutMapping("/{id}")
    public void updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        warehouseRepository.updateWarehouse(id, warehouse);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable Long id) {
        warehouseRepository.deleteWarehouse(id);
    }

}
