package com.example.demo.entity;

import lombok.Setter;

@Setter
public class Product {

    private Long productId;
    private String name;
    private String type;
    private int price;
    private String color;
    private boolean disponibility;
    private Warehouse warehouse;

    public Product(long productId, String name, String type, int price, String color, boolean disponibility) {
        this.productId = productId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.color = color;
        this.disponibility = disponibility;
    }

    public Product(Long productId, String name, String type, int price, Warehouse warehouse) {
        this.productId = productId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.warehouse = warehouse;
    }


    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public boolean isDisponibility() {
        return disponibility;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }
}
