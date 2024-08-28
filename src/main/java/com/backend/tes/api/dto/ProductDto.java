package com.backend.tes.api.dto;

import java.util.List;

public record ProductDto(
        Long id,
        String brand,
        String code,
        String name,
        String shortDescription,
        List<ProductVariantDto> productVariants
) {

}
