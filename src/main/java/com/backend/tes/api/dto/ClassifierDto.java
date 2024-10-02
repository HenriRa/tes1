package com.backend.tes.api.dto;

import com.backend.tes.domain.PriceInterval;

import java.util.List;

public record ClassifierDto(
        List<String> productGroups,
        List<String> brands,
        List<String> colors,
        List<String> priceIntervals
) {
}
