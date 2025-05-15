package com.example.sofra_backend.model;

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

    private String restaurantId;
    private String menuItemId;
    private int stock; // mevcut stok adedi
}
