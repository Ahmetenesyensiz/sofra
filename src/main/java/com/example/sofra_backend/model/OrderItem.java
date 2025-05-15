package com.example.sofra_backend.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @NotBlank(message = "Menu item ID is mandatory")
    private String menuItemId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
}
