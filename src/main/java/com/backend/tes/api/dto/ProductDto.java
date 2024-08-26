package com.backend.tes.api.dto;

import com.backend.tes.domain.ProductVariant;

import java.util.List;

public record ProductDto(
        Long id,
        String brand,
        String code,
        String name,
        String shortDescription,
        List<ProductVariant> productVariants

) {

}
