package com.example.inventariominimarket.mapper;

import com.example.inventariominimarket.dto.request.ProductRequestDTO;
import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.dto.response.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {


    @Mapping(source = "product.id",target = "id")
    @Mapping(source = "product.name",target = "name")
    @Mapping(source = "product.stock",target = "stock")
    @Mapping(source = "product.batch",target = "batch")
    @Mapping(source = "product.purchasePrice",target = "purchasePrice")
    @Mapping(source = "product.salePrice",target = "salePrice")
    @Mapping(source = "product.creationDate",target = "creationDate")
    @Mapping(source = "product.updateDate",target = "updateDate")
    @Mapping(source = "product.category",target = "category")
    ProductResponseDTO toDTO(Product product);


    @Mapping(source = "productRequestDTO.name",target = "name")
    @Mapping(source = "productRequestDTO.description",target = "description")
    @Mapping(source = "productRequestDTO.stock",target = "stock")
    @Mapping(source = "productRequestDTO.batch",target = "batch")
    @Mapping(source = "productRequestDTO.purchasePrice",target = "purchasePrice")
    @Mapping(source = "productRequestDTO.salePrice",target = "salePrice")
    @Mapping(source = "productRequestDTO.dueDate",target = "dueDate")
    @Mapping(source = "productRequestDTO.categoryId",target = "category.id")

    Product toEntity(ProductRequestDTO productRequestDTO);


    default List<ProductResponseDTO> toDTOList(List<Product> productList){
        if (productList == null){
            return new ArrayList<>();
        }
        return productList.stream().map(this::toDTO).collect(Collectors.toList());
    }


}
