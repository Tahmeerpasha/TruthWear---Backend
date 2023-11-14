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
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
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


                        // Allow access to authenticated users to all products URLs
                        .requestMatchers(HttpMethod.GET, "/api/products").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/products").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/products/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/products/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/products").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/products").hasRole("ADMIN")


                        // Allow access to authenticated users to all reviews URLs
                        .requestMatchers(HttpMethod.GET, "/api/reviews").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/reviews").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/reviews/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/reviews/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/reviews").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/reviews/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/reviews/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/reviews/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/reviews").hasRole("ADMIN")


                        // Allow access to authenticated users to all promotion URLs
                        .requestMatchers(HttpMethod.GET, "/api/promotions").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/promotions").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/promotions/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/promotions/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/promotions").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/promotions/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/promotions/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/promotions/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/promotions").hasRole("ADMIN")

                        // Allow access to authenticated users to all promotion categories URLs
                        .requestMatchers(HttpMethod.GET, "/api/promotion_categories").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/promotion_categories").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/promotion_categories/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/promotion_categories/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/promotion_categories").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/promotion_categories/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/promotion_categories/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/promotion_categories/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/promotion_categories").hasRole("ADMIN")

                        // Allow access to authenticated users to all promotion categories URLs
                        .requestMatchers(HttpMethod.GET, "/api/shopping_carts").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shopping_carts").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shopping_carts/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shopping_carts/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shopping_carts").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shopping_carts/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/shopping_carts/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/shopping_carts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/shopping_carts").hasRole("ADMIN")


                        // Allow access to authenticated users to all shopping carts items URLs
                        .requestMatchers(HttpMethod.GET, "/api/shopping_cart_items").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shopping_cart_items").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shopping_cart_items/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shopping_cart_items/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shopping_cart_items").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shopping_cart_items/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/shopping_cart_items/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/shopping_cart_items/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/shopping_cart_items").hasRole("ADMIN")


                        // Allow access to authenticated users to all shop_orders URLs
                        .requestMatchers(HttpMethod.GET, "/api/shop_orders").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shop_orders").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shop_orders/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shop_orders/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shop_orders").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shop_orders/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/shop_orders/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/shop_orders/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/shop_orders").hasRole("ADMIN")

                        // Allow access to authenticated users to all user_payments URLs
                        .requestMatchers(HttpMethod.GET, "/api/user_payments").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/user_payments").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/user_payments/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/user_payments/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/user_payments").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/user_payments/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/user_payments/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/user_payments/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/user_payments").hasRole("ADMIN")


                        // Allow access to authenticated users to all order_payment_methods URLs
                        .requestMatchers(HttpMethod.GET, "/api/order_payment_methods").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_payment_methods").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_payment_methods/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_payment_methods/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/order_payment_methods").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/order_payment_methods/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/order_payment_methods/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/order_payment_methods/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/order_payment_methods").hasRole("ADMIN")

                        // Allow access to authenticated users to all order_lines URLs
                        .requestMatchers(HttpMethod.GET, "/api/order_lines").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_lines").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_lines/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_lines/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/order_lines").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/order_lines/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/order_lines/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/order_lines/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/order_lines").hasRole("ADMIN")


                        // Allow access to authenticated users to all order_status URLs
                        .requestMatchers(HttpMethod.GET, "/api/order_status").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_status").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_status/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/order_status/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/order_status").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/order_status/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/order_status/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/order_status/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/order_status").hasRole("ADMIN")


                        // Allow access to authenticated users to all shipping_methods URLs
                        .requestMatchers(HttpMethod.GET, "/api/shipping_methods").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shipping_methods").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shipping_methods/search").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/shipping_methods/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shipping_methods").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/shipping_methods/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/shipping_methods/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/shipping_methods/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/shipping_methods").hasRole("ADMIN")
        );
        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
// disable Cross Site Request Forgery (CSRF)
//        Remove this during production
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}