package com.example.inventariominimarket.service;

import com.example.inventariominimarket.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Product product,Long id);
    Integer delete(Long id);
}
