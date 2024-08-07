package com.backend.tes.domain;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor
public class OrderLine {
    private Long id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
    private Long productId;
    private String productCode;
    private String productName;
    private String productBrand;
    private String productColor;
    private BigDecimal productPrice;
    private Integer qty;
    private BigDecimal lineAmount;
    // do we need order status for each line?
}
