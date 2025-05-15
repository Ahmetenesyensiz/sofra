package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Role;
import com.example.sofra_backend.model.User;
import com.example.sofra_backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostConstruct
    private void createAdminUser() {
        String adminEmail = "admin@mail.com";
        Optional<User> adminUser = userRepository.findByEmail(adminEmail);

        if (adminUser.isEmpty()) {
            User admin = User.builder()
                    .name("Admin User")
                    .email(adminEmail)
                    .password(passwordEncoder.encode("admin123")) // İstersen değiştir
                    .role(Role.ADMIN)
                    .createdAt(new Date())
                    .build();
            userRepository.save(admin);
            log.info("Admin user oluşturuldu: {}", adminEmail);
        }
    }

    public String register(String name, String email, String password, Role role) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Bu email zaten kayıtlı.");
        }

        User user = User.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role)
                .createdAt(new Date())
                .build();

        userRepository.save(user);
        return jwtService.generateToken(user);
    }

    public String authenticate(String email, String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (AuthenticationException e) {
            throw new IllegalArgumentException("Geçersiz email veya şifre");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Kullanıcı bulunamadı"));

        return jwtService.generateToken(user);
    }
}
