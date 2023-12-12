package com.example.inventariominimarket.repository;

import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("FROM Product p WHERE p.productStatus = com.example.inventariominimarket.entity.Status.ACTIVE")
    List<Product> findAllProduct();

    @Modifying
    @Query("UPDATE Product p SET p.productStatus = com.example.inventariominimarket.entity.Status.INACTIVE WHERE p.id = :id")
    Integer deleteProduct(@Param("id") Long id);

    List<Product> findAllByCategory(Category category);

    List<Product> findAllByNameContaining(String name);

}
