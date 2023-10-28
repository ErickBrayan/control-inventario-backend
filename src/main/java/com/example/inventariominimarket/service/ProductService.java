package com.example.inventariominimarket.service;

import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.payload.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Product product,Long id);
    Integer delete(Long id);
}
