package com.backend.tes.api.dto;

import java.math.BigInteger;
import java.util.List;

public record ProductDto(
        Long id,
        String brand,
        String code,
        String name,
        String shortDescription,
        BigInteger orderCount,
        List<ProductVariantDto> productVariants
) {

}
