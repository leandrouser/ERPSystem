package com.empresa.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**").permitAll() // Libera endpoints públicos
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Somente ADMIN
                        .requestMatchers("/api/vendedor/**").hasRole("VENDEDOR") // Somente VENDEDOR
                        .requestMatchers("/api/cliente/**").hasRole("CLIENTE") // Somente CLIENTE
                        .requestMatchers("/swagger-ui.html", "/v3/api-docs/*", "/swagger-ui/*",
                                "/swagger-resources/*", "/webjars/*").permitAll()
                        .anyRequest().permitAll() // Exige autenticação para todos os outros endpoints

                )
                .csrf().disable()
                .httpBasic(); // Usa autenticação básica (usuário e senha)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}