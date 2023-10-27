package com.example.inventariominimarket.service.impl;

import com.example.inventariominimarket.entity.Supplier;
import com.example.inventariominimarket.repository.SupplierRepository;
import com.example.inventariominimarket.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier, Long id) {
        boolean isPresent = supplierRepository.findById(id).isPresent();
        return isPresent ? supplierRepository.save(supplier) : null;
    }

    @Override
    public boolean delete(Long id) {
        if (supplierRepository.existsById(id)){
            supplierRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
