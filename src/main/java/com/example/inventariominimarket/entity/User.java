package com.example.inventariominimarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USERS")
public class User {

    @Id
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    
}
