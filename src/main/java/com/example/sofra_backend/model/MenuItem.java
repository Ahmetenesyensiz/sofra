package com.example.sofra_backend.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "menuItems")
public class MenuItem {

    @Id
    private String id;

    @NotBlank(message = "Restaurant ID is mandatory")
    private String restaurantId;  // Hangi restorana ait

    @NotBlank(message = "Menu item name is mandatory")
    private String name;

    private String description;

    @Min(value = 0, message = "Price must be at least 0")
    private double price;

    private String imageUrl;

    @NotBlank(message = "Category is mandatory")
    private String category;

    private boolean isAvailable;
}
