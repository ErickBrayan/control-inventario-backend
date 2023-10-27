package com.example.inventariominimarket.repository;

import com.example.inventariominimarket.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("FROM Product WHERE productStatus = com.example.inventariominimarket.entity.ProductStatus.CREATED")
    List<Product> findAllProduct();

    Boolean deleteProduct();
}
