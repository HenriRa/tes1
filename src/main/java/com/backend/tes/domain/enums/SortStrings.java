package com.backend.tes.domain.enums;

public enum SortStrings {
    POPULAR_DESC("orderCount,desc"),
    PRICE_ASC("pv.monthlyPrice,asc"),
    PRICE_DESC("pv.monthlyPrice,desc");

    private final String value;

    SortStrings(String value) {
        this.value = value;
    }
}
