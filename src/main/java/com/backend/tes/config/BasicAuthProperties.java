package com.backend.tes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.security.user")
public record BasicAuthProperties(
        String name,
        String password
) {
}
