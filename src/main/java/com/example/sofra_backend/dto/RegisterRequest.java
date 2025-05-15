package com.example.sofra_backend.dto;

import com.example.sofra_backend.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role; // isteğe bağlı (default CUSTOMER)
}
