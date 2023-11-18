package com.truthwear.truthwear.auth;

import com.truthwear.truthwear.config.JwtService;
import com.truthwear.truthwear.entity.Role;
import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final SiteUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = SiteUser.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .emailId(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        Map<String,String> jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken.get("access_token"))
                .refreshToken(jwtToken.get("refresh_token"))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest registerRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerRequest.getEmail(),
                        registerRequest.getPassword()
                )
        );
        var user = userRepository.findByEmailId(registerRequest.getEmail()).orElseThrow();
        Map<String,String> jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken.get("access_token"))
                .refreshToken(jwtToken.get("refresh_token"))
                .build();
    }

    public ResponseEntity<Map<String, String>> refreshToken(String refreshToken) {
        // Validate the refresh token (you might want to check against a database or some storage)
        if (isValidRefreshToken(refreshToken)) {
            UserDetails userDetails = loadUserDetailsFromToken(refreshToken);

            // If the refresh token is valid, generate a new access token
            String newAccessToken = jwtService.generateToken(userDetails).get("access_token");

            Map<String, String> response = new HashMap<>();
            response.put("access_token", newAccessToken);

            return ResponseEntity.ok(response);
        } else {
            // Handle invalid refresh token
            return ResponseEntity.badRequest().build();
        }
    }
    // Example method to validate the refresh token (you might want to check against a database or some storage)
    private boolean isValidRefreshToken(String refreshToken) {
        return refreshToken != null && jwtService.isTokenValid(refreshToken, loadUserDetailsFromToken(refreshToken));
    }

    // Example method to load UserDetails from the refresh token
    private UserDetails loadUserDetailsFromToken(String refreshToken) {
        String username = jwtService.extractUserName(refreshToken);
        // Load UserDetails from your UserDetailsService or any other source
        // Example: return customUserDetailsService.loadUserByUsername(username);
        return userRepository.findByEmailId(username).get();
    }
}
