package com.example.inventariominimarket.service.impl;

import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.repository.CategoryRepository;
import com.example.inventariominimarket.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category, Long id) {
        boolean isPresent = categoryRepository.findById(id).isPresent();
        return isPresent ? categoryRepository.save(category) : null;
    }

    @Override
    public boolean delete(Long id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
