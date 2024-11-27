package com.backend.tes.api.dto;

import java.util.List;

public record ProductResponseDto(
        List<ProductDto> content,
        int pageNo,
        int pageSize,
        long totalElements,
        int totalPages,
        boolean last
) {
}
