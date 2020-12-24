package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @PostMapping("/request")
    public void createProduct(@RequestBody Product product) {
        productRepository.createProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productRepository.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteProduct(id);
    }

//    Product - Warehouse
    @GetMapping("/product-warehouse/{id}")
    public List<Product> findWarehouseByProduct(@PathVariable Long id) {
        List<Product> productList = productRepository.findWarehouseByProduct(id);
        return productList;
    }
}
