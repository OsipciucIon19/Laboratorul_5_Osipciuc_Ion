package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private long employeeId;
    private String firstName;
    private String lastName;
    private String function;
    private String mail;
    private long warehouseId;
    private String adress;
    private int nrEmployees;

    public Employee(long employeeId, String first_name, String last_name, String function, String mail) {
        this.employeeId = employeeId;
        this.firstName = first_name;
        this.lastName = last_name;
        this.function = function;
        this.mail = mail;
    }

    public Employee(long employeeId, String first_name, String last_name, String function, long warehouseId, String adress, int nr_employees) {
        this.employeeId = employeeId;
        this.firstName = first_name;
        this.lastName = last_name;
        this.function = function;
        this.warehouseId = warehouseId;
        this.adress = adress;
        this.nrEmployees = nr_employees;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFunction() {
        return function;
    }

    public String getMail() {
        return mail;
    }
}
