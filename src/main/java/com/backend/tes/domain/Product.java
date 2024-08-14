package com.backend.tes.domain;

import jakarta.persistence.*;
import lombok.*;

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
    private int brandId;
    private int colorId;
    private String sku;
    private String title;
    private String description;
    private String img_url;

}
