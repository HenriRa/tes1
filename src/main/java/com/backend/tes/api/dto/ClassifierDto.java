package com.backend.tes.api.dto;

import java.util.List;

public record ClassifierDto(
        List<String> productGroups,
        List<String> brands,
        List<String> colors,
        List<String> priceIntervals,
        List<String> stockOptions
) {}
