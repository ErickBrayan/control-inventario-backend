package com.example.inventariominimarket.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PRODUCTS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double stock;
    private String description;
    private BigDecimal price;

    @CreationTimestamp
    @Column(name = "creation_date",updatable = false,nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date",nullable = false)
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    private Category category;

    @PrePersist
    void setPrePersit(){
        this.productStatus = ProductStatus.CREATED;
    }
}
