package com.example.sofra_backend.model;

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

    private String restaurantId;  // Hangi restorana ait
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
    private boolean isAvailable;
}
