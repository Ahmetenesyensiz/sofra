package com.example.sofra_backend.controller;

import com.example.sofra_backend.dto.LoginRequest;
import com.example.sofra_backend.dto.RegisterRequest;
import com.example.sofra_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }
}
