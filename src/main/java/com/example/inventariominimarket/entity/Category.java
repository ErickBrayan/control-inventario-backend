package com.example.inventariominimarket.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CATEGORY")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

}
