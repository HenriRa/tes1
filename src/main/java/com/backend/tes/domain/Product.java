package com.backend.tes.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

@Table(name="product")
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

    private Blob picture;

    private String color;
    private BigDecimal price;
    private String description;

}
