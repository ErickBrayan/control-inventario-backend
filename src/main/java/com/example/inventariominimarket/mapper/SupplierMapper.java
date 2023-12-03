package com.example.inventariominimarket.mapper;

import com.example.inventariominimarket.dto.request.SupplierRequestDTO;
import com.example.inventariominimarket.dto.response.SupplierResponseDTO;
import com.example.inventariominimarket.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplierMapper {
    @Mapping(source = "supplier.id",target = "id")
    @Mapping(source = "supplier.name",target = "name")
    @Mapping(source = "supplier.ruc",target = "ruc")
    @Mapping(source = "supplier.address",target = "address")
    @Mapping(source = "supplier.phoneContact",target = "phoneContact")
    @Mapping(source = "supplier.email",target = "email")
    @Mapping(source = "supplier.creationDate",target = "creationDate")
    @Mapping(source = "supplier.updateDate",target = "updateDate")
    @Mapping(source = "supplier.supplierStatus",target = "supplierStatus")
    SupplierResponseDTO toDTO(Supplier supplier);


    @Mapping(source = "requestDTO.name",target = "name")
    @Mapping(source = "requestDTO.ruc",target = "ruc")
    @Mapping(source = "requestDTO.address",target = "address")
    @Mapping(source = "requestDTO.phoneContact",target = "phoneContact")
    @Mapping(source = "requestDTO.email",target = "email")
    Supplier toEntity(SupplierRequestDTO requestDTO);

    default List<SupplierResponseDTO> toDtoList(List<Supplier> suppliers){
        if (suppliers == null){
            return new ArrayList<>();
        }
        return suppliers.stream().map(this::toDTO).collect(Collectors.toList());
    }



}
