package com.backend.tes.api.dto;

import com.backend.tes.domain.Color;
import com.backend.tes.domain.Stock;

import java.math.BigDecimal;

public record ProductVariantDto(
        Color color,
        String imgUrl,
        BigDecimal fullPrice,
        BigDecimal monthlyPrice,
        Boolean defaultVariant,
        Stock stock
) {
}
