package com.example.demo.entity;

import lombok.Setter;

@Setter
public class Warehouse {

    private long id;
    private String adress;
    private long nrEmployees;

    public Warehouse(long id, String adress, long nr_employees) {
        this.id = id;
        this.adress = adress;
        this.nrEmployees = nr_employees;
    }

    public long getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public long getNrEmployees() {
        return nrEmployees;
    }
}
