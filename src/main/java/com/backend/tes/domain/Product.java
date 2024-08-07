package com.backend.tes.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name="products")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
    private String code;
    private String name;
    private String brand;
    private String color;
//    private BigDecimal price;
//    private String description;

}
