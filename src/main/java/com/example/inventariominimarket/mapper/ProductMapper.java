package com.example.inventariominimarket.mapper;

import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.payload.response.ProductResponseDTO;
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
    @Mapping(source = "product.description",target = "description")
    @Mapping(source = "product.price",target = "price")
    @Mapping(source = "product.creationDate",target = "creationDate")
    @Mapping(source = "product.updateDate",target = "updateDate")
    @Mapping(source = "product.productStatus",target = "status")
    ProductResponseDTO toDTO(Product product);


    default List<ProductResponseDTO> toDTOList(List<Product> productList){
        if (productList == null){
            return new ArrayList<>();
        }

        return productList.stream().map(this::toDTO).collect(Collectors.toList());


    }


}
