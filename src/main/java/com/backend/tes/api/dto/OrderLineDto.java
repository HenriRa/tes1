package com.backend.tes.api.dto;

import com.backend.tes.domain.ProductVariant;

import java.math.BigDecimal;

public record OrderLineDto(
        Integer lineNo,
        ProductVariantDto productVariant,
        Integer quantity,
        BigDecimal totalLineAmount
) {
}
