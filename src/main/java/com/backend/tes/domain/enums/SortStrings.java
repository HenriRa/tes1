package com.backend.tes.domain.enums;

import lombok.Getter;

@Getter
public enum SortStrings {
    POPULAR_DESC("orderCount"),
    PRICE_ASC("pv.monthlyPrice"),
    PRICE_DESC("pv.monthlyPrice");

    private final String value;

    SortStrings(String value) {
        this.value = value;
    }

}
