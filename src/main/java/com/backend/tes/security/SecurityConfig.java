package com.backend.tes.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.regex.Pattern;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String INCLUDE_REGEX_PATTERN = "^(%s)$";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf
                            .ignoringRequestMatchers(toH2Console()).disable())
                    .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                    .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                            "/swagger-ui/**",
                            "/api-docs/**",
                            "/actuator/**",
                            "/health/**",
                            "/error.*").permitAll()
                            .requestMatchers(toH2Console()).permitAll()
                        .anyRequest().authenticated()
                    )
                    .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails adminUser = User
                .withUsername("admin")
                .password(passwordEncoder().encode("Admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public RequestMatcher getRequestMatcher(final String paths) {
        final Pattern pattern = Pattern.compile(INCLUDE_REGEX_PATTERN.formatted(paths));
        return request -> pattern.matcher(request.getServletPath()).matches();
    }

}
