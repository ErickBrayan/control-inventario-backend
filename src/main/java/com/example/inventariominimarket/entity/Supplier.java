package com.example.inventariominimarket.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SUPPLIER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ruc;
    private String address;

    @Column(name = "phone_contact")
    private String phoneContact;

    private String email;

    @CreationTimestamp
    @Column(name = "creation_date",updatable = false,nullable = false)
    private LocalDateTime creationDate;


    @UpdateTimestamp
    @Column(name = "update_date",nullable = false)
    private LocalDateTime updateDate;


    @Enumerated(EnumType.STRING)
    private Status supplierStatus;


    @PrePersist
    void setPrePersist(){
        this.supplierStatus = Status.ACTIVE;
    }

}
