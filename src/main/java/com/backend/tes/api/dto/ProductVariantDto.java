package com.backend.tes.api.dto;

import com.backend.tes.domain.Stock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

public record ProductVariantDto(
        String color,
        String imgUrl,
        BigDecimal monthlyPrice,
        Boolean defaultVariant,
        Set<StockDto> stock
) {
}
