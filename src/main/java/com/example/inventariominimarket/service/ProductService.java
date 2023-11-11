package com.example.inventariominimarket.service;

import com.example.inventariominimarket.dto.request.ProductRequestDTO;
import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> findAll();
    List<ProductResponseDTO> findAllProductToExpired(int days);
    List<ProductResponseDTO> findAllProductByStock(int stock);
    ProductResponseDTO findById(Long id);
    List<ProductResponseDTO> findAllByCategory(Long id);
    List<ProductResponseDTO> findAllByName(String name);
    Product save(ProductRequestDTO productRequestDTO);
    Product update(ProductRequestDTO productRequestDTO,Long id);
    Integer delete(Long id);
}
