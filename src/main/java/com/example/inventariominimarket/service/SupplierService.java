package com.example.inventariominimarket.service;

import com.example.inventariominimarket.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();
    Supplier findById(Long id);
    Supplier save(Supplier supplier);
    Supplier update(Supplier supplier,Long id);
    boolean delete(Long id);
}
