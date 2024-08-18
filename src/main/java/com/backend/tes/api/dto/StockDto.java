package com.backend.tes.api.dto;

public record StockDto(
        ProductVariantDto productVariant,
        Integer qtyInStock
) {
}
