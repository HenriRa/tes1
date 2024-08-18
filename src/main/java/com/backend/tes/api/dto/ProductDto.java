package com.backend.tes.api.dto;

import com.backend.tes.domain.Brand;

import java.util.List;

public record ProductDto(
        BrandDto brand,
        String code,
        String name,
        String shortDescription,
        List<ProductVariantDto> productVariants

) {

}
