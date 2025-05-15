package com.example.sofra_backend.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;

    @NotBlank(message = "Owner ID is mandatory")
    private String ownerId; // User tablosundaki owner user ID

    @NotBlank(message = "Restaurant name is mandatory")
    private String name;

    @NotBlank(message = "Restaurant location is mandatory")
    private String location; // tam adres gibi

    private String description; // opsiyonel açıklama

    private Double latitude; // Google Maps için enlem
    private Double longitude; // Google Maps için boylam
}
