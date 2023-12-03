package com.example.inventariominimarket.service;


import com.example.inventariominimarket.dto.request.CategoryRequestDTO;
import com.example.inventariominimarket.dto.response.CategoryResponseDTO;
import com.example.inventariominimarket.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO findById(Long id);
    Category save(CategoryRequestDTO categoryRequestDTO);

    Category update(CategoryRequestDTO categoryRequestDTO, Long id);
    boolean delete(Long id);
}
