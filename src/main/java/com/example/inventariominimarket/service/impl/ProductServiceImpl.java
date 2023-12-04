package com.example.inventariominimarket.service.impl;

import com.example.inventariominimarket.dto.request.ProductRequestDTO;
import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.entity.ProductStatus;
import com.example.inventariominimarket.mapper.ProductMapper;
import com.example.inventariominimarket.dto.response.ProductResponseDTO;
import com.example.inventariominimarket.repository.ProductRepository;
import com.example.inventariominimarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    @Override
    @Transactional
    public List<ProductResponseDTO> findAll() {
        return productMapper.toDTOList(productRepository.findAllProduct());
    }

    @Override
    public List<ProductResponseDTO> findAllProductToExpired(int days) {
        LocalDate nowDate = LocalDate.now();

        return productRepository.findAllProduct().stream()
                .filter(product -> {
                    long daysToExpired = ChronoUnit.DAYS.between(nowDate, product.getDueDate());
                    return daysToExpired > 0 && daysToExpired <= days;
                })
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> findAllProductByStock(int stock) {
        return productRepository.findAllProduct().stream()
                .filter(product -> product.getStock() <= stock)
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductResponseDTO findById(Long id) {
        return productMapper.toDTO(productRepository.findById(id).orElse(null));
    }

    @Override
    public List<ProductResponseDTO> findAllByCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        return productMapper.toDTOList(productRepository.findAllByCategory(category));
    }

    @Override
    public List<ProductResponseDTO> findAllByName(String name) {
        return productMapper.toDTOList(productRepository.findAllByNameContaining(name));
    }


    @Override
    @Transactional
    public Product save(ProductRequestDTO productRequestDTO) {
        return productRepository.save(productMapper.toEntity(productRequestDTO));
    }


    @Override
    @Transactional
    public Product update(ProductRequestDTO productRequestDTO, Long id) {
        boolean isPresent = productRepository.findById(id).isPresent();
        Product product = productMapper.toEntity(productRequestDTO);
        product.setId(id);
        product.setProductStatus(ProductStatus.CREATED);
        return isPresent ? productRepository.save(product) : null;
    }

    @Override
    @Transactional
    public Integer delete(Long id) {
        boolean isPresent = productRepository.findById(id).isPresent();
        if (!isPresent) {
            return 3;
        }
        return productRepository.deleteProduct(id);
    }


}
