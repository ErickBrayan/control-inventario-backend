package com.example.inventariominimarket.mapper;

import com.example.inventariominimarket.dto.request.CategoryRequestDTO;
import com.example.inventariominimarket.dto.response.CategoryResponseDTO;
import com.example.inventariominimarket.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(source = "category.id",target = "id")
    @Mapping(source = "category.description",target = "description")
    CategoryResponseDTO toDTO(Category category);

    @Mapping(source = "categoryRequestDTO.description",target = "description")
    Category toEntity(CategoryRequestDTO categoryRequestDTO);


    default List<CategoryResponseDTO> toList(List<Category> categoryList){

        if(categoryList == null){
            return new ArrayList<>();
        }

        return categoryList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
