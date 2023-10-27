package com.example.inventariominimarket.service;

import com.example.inventariominimarket.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Category category,Long id);
    boolean delete(Long id);
}
