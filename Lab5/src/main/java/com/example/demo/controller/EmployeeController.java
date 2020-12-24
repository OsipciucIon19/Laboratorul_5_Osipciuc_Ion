package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        Employee employee = (Employee) employeeRepository.findById(id);
        return employee;
    }

    @PostMapping("/request")
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeRepository.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteEmployee(id);
    }

//    Employee-Warehouse
    @GetMapping("/warehouse-employee/{id}")
    public List<Employee> findEmployeeByWarehouse(@PathVariable Long id) {
        List<Employee> employeeList = employeeRepository.findEmployeeByWarehouse(id);
        return employeeList;
    }
}
