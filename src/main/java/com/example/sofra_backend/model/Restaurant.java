package com.example.sofra_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;

    private String ownerId; // User tablosundaki owner user ID
    private String name;
    private String location;
    private String description;
}
