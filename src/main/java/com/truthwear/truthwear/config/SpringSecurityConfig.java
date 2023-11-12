package com.truthwear.truthwear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        // Allow access to all users URLs for authenticated users and admins
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")

                        // Allow access to authenticated users to all addresses URLs
                        .requestMatchers(HttpMethod.GET, "/api/addresses").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/addresses/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/addresses/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/addresses/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/addresses/**").hasRole("ADMIN")

                        // Allow access to authenticated users to all product categories URLs
                        .requestMatchers(HttpMethod.GET, "/api/product_categories").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/product_category").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/product_categories/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/product_categories/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/product_categories/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/product_categories/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/product_categories").hasRole("ADMIN")


                        // Allow access to authenticated users to all product categories URLs
                        .requestMatchers(HttpMethod.GET, "/api/products").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/products").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/products/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/products/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/products").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/products").hasRole("ADMIN")


                        // Allow access to authenticated users to all product categories URLs
                        .requestMatchers(HttpMethod.GET, "/api/reviews").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/reviews").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/reviews/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/reviews/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/reviews").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/reviews/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/reviews/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/reviews/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/reviews").hasRole("ADMIN")
        );
        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
// disable Cross Site Request Forgery (CSRF)
//        Remove this during production
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}