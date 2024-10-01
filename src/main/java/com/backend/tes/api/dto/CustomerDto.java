package com.backend.tes.api.dto;

import com.backend.tes.domain.Address;

import java.util.List;

public record CustomerDto (
        String firstName,
        String lastName,
        String email,
        String telephone
){
}
