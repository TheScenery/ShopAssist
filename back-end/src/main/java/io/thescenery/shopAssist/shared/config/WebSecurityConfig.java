package io.thescenery.shopAssist.shared.config;

import io.thescenery.shopAssist.shared.filter.JWTTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Order(1)
  public SecurityFilterChain noAuthFilterChain(HttpSecurity http) throws Exception {
    http.securityMatcher("/api/auth/login").authorizeHttpRequests(authorize -> authorize
        .anyRequest().permitAll()
    ).csrf(AbstractHttpConfigurer::disable);

    return http.build();
  }

  @Bean
  @Order(2)
  public SecurityFilterChain authFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorize -> authorize
            .anyRequest().authenticated()
        ).csrf(AbstractHttpConfigurer::disable)
        .addFilterBefore(new JWTTokenFilter(), AuthorizationFilter.class)
        .exceptionHandling(exception -> exception.authenticationEntryPoint(new HttpStatusEntryPoint(
            HttpStatus.UNAUTHORIZED)));

    return http.build();
  }
}
