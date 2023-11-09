package com.example.inventariominimarket.service;

import com.example.inventariominimarket.dto.request.SupplierRequestDTO;
import com.example.inventariominimarket.dto.response.SupplierResponseDTO;
import com.example.inventariominimarket.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<SupplierResponseDTO> findAll();
    SupplierResponseDTO findById(Long id);
    Supplier save(SupplierRequestDTO supplierRequestDTO);
    Supplier update(SupplierRequestDTO supplierRequestDTO, Long id);
    Integer delete(Long id);
}
