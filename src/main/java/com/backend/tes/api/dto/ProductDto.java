package com.backend.tes.api.dto;

public record ProductDto(
        Long id,
        String brand,
        String color,
        String sku,
        String title,
        String description,
        String img_url

) {

}
