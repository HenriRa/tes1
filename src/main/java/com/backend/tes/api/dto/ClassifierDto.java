package com.backend.tes.api.dto;

import java.util.List;

public record ClassifierDto(
        List<String> brands,
        List<String> colors
) {
}
