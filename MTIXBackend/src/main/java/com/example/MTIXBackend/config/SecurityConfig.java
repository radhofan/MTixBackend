package com.example.MTIXBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())  // Using the new lambda style configuration
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**").permitAll()  // Using requestMatchers instead of antMatchers
                            .anyRequest().authenticated();
                })
                .cors(cors -> cors.configure(http))  // Configure CORS using the new style
                .build();
    }
}