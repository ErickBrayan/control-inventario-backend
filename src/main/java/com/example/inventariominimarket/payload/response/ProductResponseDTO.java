package com.example.inventariominimarket.payload.response;


import com.example.inventariominimarket.entity.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDTO {

    private Long id;

    private String name;
    private int stock;
    private String description;
    private BigDecimal price;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private ProductStatus status;
    //private Long category_id;
}
