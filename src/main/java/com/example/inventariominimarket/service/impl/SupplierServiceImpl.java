package com.example.inventariominimarket.service.impl;

import com.example.inventariominimarket.dto.request.SupplierRequestDTO;
import com.example.inventariominimarket.dto.response.SupplierResponseDTO;
import com.example.inventariominimarket.entity.Supplier;
import com.example.inventariominimarket.entity.SupplierStatus;
import com.example.inventariominimarket.mapper.SupplierMapper;
import com.example.inventariominimarket.repository.SupplierRepository;
import com.example.inventariominimarket.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final SupplierMapper supplierMapper;

    @Override
    @Transactional
    public List<SupplierResponseDTO> findAll() {
        return supplierMapper.toDtoList(supplierRepository.findAllSupplier());
    }

    @Override
    @Transactional
    public SupplierResponseDTO findById(Long id) {
        return supplierMapper.toDTO(supplierRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public Supplier save(SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = supplierMapper.toEntity(supplierRequestDTO);
        return supplierRepository.save(supplier);
    }

    /**
     * Updates a supplier with the given ID using the information provided in the request body.
     *
     * @param supplierRequestDTO the DTO containing the updated supplier information
     * @param id the ID of the supplier to be updated
     * @return a ResponseEntity containing the updated supplier if successful, or a NOT_FOUND status code if the supplier was not found
     */
    @Override
    @Transactional
    public Supplier update(SupplierRequestDTO supplierRequestDTO, Long id) {
        boolean isPresent = supplierRepository.findById(id).isPresent();
        Supplier supplier = supplierMapper.toEntity(supplierRequestDTO);
        supplier.setId(id);
        supplier.setSupplierStatus(SupplierStatus.CREATED);
        return isPresent ? supplierRepository.save(supplier) : null;
    }

    @Override
    @Transactional
    public Integer delete(Long id) {
        boolean isPresent = supplierRepository.findById(id).isPresent();
        if (!isPresent){
            return 3;
        }
        return supplierRepository.deleteSupplier(id);
    }
}
