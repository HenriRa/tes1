package com.backend.tes.api.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductVariantDto(
        String color,
        String imgUrl,
        BigDecimal fullPrice,
        BigDecimal monthlyPrice,
        Boolean defaultVariant,
        BigInteger stock
) {
}
