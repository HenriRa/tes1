package com.backend.tes.domain;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor
public class Stock {
    private Long id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
    private String productCode;
    private Boolean inStock;
    private Integer qtyInStock;

    private Long productId;
}
