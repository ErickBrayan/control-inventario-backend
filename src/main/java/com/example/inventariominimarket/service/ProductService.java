package com.example.inventariominimarket.service;

import com.example.inventariominimarket.dto.request.ProductRequestDTO;
import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> findAll();
    Product findById(Long id);
    Product save(ProductRequestDTO productRequestDTO);
    Product update(Product product,Long id);
    Integer delete(Long id);
}
