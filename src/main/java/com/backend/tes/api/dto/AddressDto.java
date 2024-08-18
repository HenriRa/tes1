package com.backend.tes.api.dto;

public record AddressDto(
        String address1,
        String address2,
        String city,
        String country,
        Boolean defaultAddress

) {
}
