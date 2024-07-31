package com.addtech.admin.config;

import com.addtech.admin.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebSecurityCustomizer {

    private static final String[] SWAGGER_ENDPOINTS =
            new String[]{
                    "/v3/api-docs/**",
                    "/configuration/ui/**",
                    "/swagger-resources/**",
                    "/configuration/security/**",
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/documentation",
                    "/webjars/**"
            };

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(c -> c.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs",
                                "/api/v1/auth",
                                "/docs"
                        ).permitAll()
                        .anyRequest().authenticated()
                );
        http.exceptionHandling(exceptions -> exceptions.authenticationEntryPoint(new JwtAuthenticationEntryPoint()));
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Override
    public void customize(WebSecurity web) {
        web.ignoring()
                .requestMatchers(SWAGGER_ENDPOINTS);
    }
}
