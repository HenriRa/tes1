package com.backend.tes.domain.query;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductByFilter(
        Long id,
        String brand,
        String code,
        String name,
        String shortDescription,
        BigInteger orderCount,
        String color,
        String imgUrl,
        BigDecimal monthlyPrice,
        Boolean defaultVariant,
        BigInteger qtyInStock
) {
}
