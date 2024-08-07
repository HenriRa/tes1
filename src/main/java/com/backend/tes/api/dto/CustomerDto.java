package com.backend.tes.api.dto;

public record CustomerDto (
        Long id,
        String firstName,
        String lastName,
        String email
){
}
