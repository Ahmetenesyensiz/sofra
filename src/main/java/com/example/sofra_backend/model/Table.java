package com.example.sofra_backend.model;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Restaurant ID is mandatory")
    private String restaurantId; // Hangi restoranın masası

    @NotBlank(message = "Table number is mandatory")
    private String tableNumber;  // Masa numarası (örneğin: "1", "2")

    @NotBlank(message = "QR code ID is mandatory")
    private String qrcodeId;     // QR kod için unique ID
}
