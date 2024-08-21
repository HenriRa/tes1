package com.backend.tes.api.dto;

import com.backend.tes.domain.Brand;
import com.backend.tes.domain.ProductVariant;

import java.util.List;

public record ProductDto(
        Long id,
        Brand brand,
        String code,
        String name,
        String shortDescription,
        List<ProductVariant> productVariants

) {

}
