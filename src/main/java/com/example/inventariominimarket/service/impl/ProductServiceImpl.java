package com.example.inventariominimarket.service.impl;

import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.mapper.ProductMapper;
import com.example.inventariominimarket.payload.response.ProductResponseDTO;
import com.example.inventariominimarket.repository.ProductRepository;
import com.example.inventariominimarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    @Override
    @Transactional
    public List<ProductResponseDTO> findAll() {
        return productMapper.toDTOList(productRepository.findAllProduct());

    }

    @Override
    @Transactional
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }


    @Override
    @Transactional
    public Product update(Product product, Long id) {
        boolean isPresent = productRepository.findById(id).isPresent();
        return isPresent ? productRepository.save(product) : null;
    }

    @Override
    @Transactional
    public Integer delete(Long id) {
        return productRepository.deleteProduct(id);
    }


}
