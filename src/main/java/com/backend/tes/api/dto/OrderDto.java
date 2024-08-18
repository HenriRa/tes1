package com.backend.tes.api.dto;

import com.backend.tes.domain.Customer;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public record OrderDto(
        Integer orderNo,
        Timestamp orderDate,
        CustomerDto customer,
        BigDecimal totalAmount,
        String status,
        List<OrderLineDto> orderLines

) {
}
