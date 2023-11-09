package com.example.inventariominimarket.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDTO {

    private String name;
    private String description;
    private Integer stock;
    private String batch;
    private LocalDate dueDate;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Long categoryId;
}
