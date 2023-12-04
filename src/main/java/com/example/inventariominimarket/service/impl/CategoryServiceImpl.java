package com.example.inventariominimarket.service.impl;


import com.example.inventariominimarket.dto.request.CategoryRequestDTO;
import com.example.inventariominimarket.dto.response.CategoryResponseDTO;
import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.mapper.CategoryMapper;
import com.example.inventariominimarket.repository.CategoryRepository;
import com.example.inventariominimarket.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    @Transactional
    public List<CategoryResponseDTO> findAll() {
        return categoryMapper.toList(categoryRepository.findAll());
    }

    @Override
    @Transactional
    public CategoryResponseDTO findById(Long id) {
        return categoryMapper.toDTO(categoryRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public Category save(CategoryRequestDTO categoryRequestDTO) {
        return categoryRepository.save(categoryMapper.toEntity(categoryRequestDTO));
    }

    @Override
    @Transactional
    public Category update(CategoryRequestDTO categoryRequestDTO, Long id) {
        boolean isPresent = categoryRepository.findById(id).isPresent();
        Category category = categoryMapper.toEntity(categoryRequestDTO);
        category.setId(id);
        return isPresent ? categoryRepository.save(category) : null;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean isPresent = categoryRepository.findById(id).isPresent();
        if (isPresent){

            categoryRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
