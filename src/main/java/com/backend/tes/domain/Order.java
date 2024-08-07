package com.backend.tes.domain;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor
public class Order {
    private Long id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
    private Integer orderNo;
    private String status;
    private Long customerId;
    private String customerName;
    private String description;
    private BigDecimal totalAmount;

    private List<OrderLine> orderLines;
    private List<OrderEvent> orderEvents;
}
