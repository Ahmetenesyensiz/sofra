package com.example.sofra_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "tables")
public class Table {

    @Id
    private String id;

    private String restaurantId; // Hangi restoranın masası
    private String tableNumber;  // Masa numarası (örneğin: "1", "2")
    private String qrcodeId;     // QR kod için unique ID
}
