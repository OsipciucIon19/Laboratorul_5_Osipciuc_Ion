package com.example.demo.repository;


import com.example.demo.entity.Product;
import com.example.demo.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        List<Product> productList = jdbcTemplate.query("SELECT * FROM product", (response, rowNumber) ->
                new Product(response.getLong("id"),
                            response.getString("name"),
                            response.getString("type"),
                            response.getInt("price"),
                            response.getString("color"),
                            response.getBoolean("disponibility")
                ));
        return productList;
    }

    public void createProduct(Product product) {
        jdbcTemplate.update("INSERT INTO product(name, type, price, color, disponibility, id_warehouse) VALUES (?,?,?,?,?,?)",
                product.getName(),
                product.getType(),
                product.getPrice(),
                product.getColor(),
                product.isDisponibility()
        );
    }

    public void updateProduct(long id, Product product) {
        jdbcTemplate.update("UPDATE product SET price = ? WHERE id = ?)",
                product.getPrice(),id);
    }

    public void deleteProduct(long id) {
        jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }

    public List<Product> findWarehouseByProduct(long id) {
        List<Product> productList = jdbcTemplate.query("SELECT p.id, p.name, p.type, p.price, w.id, w.adress, w.nr_employees  FROM product_warehouse INNER JOIN product p on p.id = product_warehouse.id_product\n" +
                "INNER JOIN warehouse w on product_warehouse.id_warehouse = w.id WHERE p.id = ?", new Object[]{id},
                (response, rowNumber) ->
                new Product(response.getLong(1),
                            response.getString("name"),
                            response.getString("type"),
                            response.getInt("price"),
                            new Warehouse(
                                    response.getLong(5),
                                    response.getString("adress"),
                                    response.getInt("nr_employees")
                            )
            ));
        return productList;
}
}
