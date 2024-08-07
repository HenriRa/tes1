package com.backend.tes.api.dto;

import java.math.BigDecimal;
import java.sql.Blob;

public record ProductDto(
        Long id,
        String code,
        String name,
        String brand,
        String color,
        BigDecimal price,
        String description,
        Blob picture
) {

}
