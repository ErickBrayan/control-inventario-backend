package com.example.inventariominimarket.repository;

import com.example.inventariominimarket.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    @Query("FROM Supplier s WHERE s.supplierStatus = com.example.inventariominimarket.entity.Status.ACTIVE")
    List<Supplier> findAllSupplier();

    @Modifying
    @Query("UPDATE Supplier s SET s.supplierStatus = com.example.inventariominimarket.entity.Status.INACTIVE WHERE s.id = :id")
    Integer deleteSupplier(@Param("id") Long id);
}
