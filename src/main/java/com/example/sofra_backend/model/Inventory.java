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
@Document(collection = "inventory")
public class Inventory {

    @Id
    private String id;

    @NotBlank(message = "Restaurant ID is mandatory")
    private String restaurantId;

    @NotBlank(message = "Menu item ID is mandatory")
    private String menuItemId;

    @Min(value = 0, message = "Stock must be at least 0")
    private int stock; // mevcut stok adedi
}
