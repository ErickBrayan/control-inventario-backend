package com.example.inventariominimarket.service.impl;

import com.example.inventariominimarket.dto.request.ProductRequestDTO;
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

    /**
     * Encuentra todos los productos que vencerán en un número específico de días a partir de la fecha actual.
     * @param days El número de días dentro de los cuales los productos caducarán.
     * @return Una lista de objetos ProductResponseDTO que representan los productos que caducarán dentro del número especificado de días.
     */
    @Override
    public List<ProductResponseDTO> findAllProductToExpired(int days) {

        LocalDate nowDate = LocalDate.now();

        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

        List<Product> products = productRepository.findAllProduct();

        for (Product product : products) {
            long daysToExpired = ChronoUnit.DAYS.between(nowDate, product.getDueDate());
            if (daysToExpired > 0 && daysToExpired <= days) {
                log.info("Product: {}", product);
                productResponseDTOList.add(productMapper.toDTO(product));
            }
        }

        return productResponseDTOList;
    }

    @Override
    @Transactional
    public ProductResponseDTO findById(Long id) {
        return productMapper.toDTO(productRepository.findById(id).orElse(null));
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
