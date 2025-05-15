package com.example.sofra_backend.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "callRequests")
public class CallRequest {

    @Id
    private String id;

    @NotBlank(message = "Restaurant ID is mandatory")
    private String restaurantId;

    @NotBlank(message = "Table ID is mandatory")
    private String tableId;

    @NotBlank(message = "User ID is mandatory")
    private String userId;

    @NotBlank(message = "Status is mandatory")
    private String status; // NEW / ACKNOWLEDGED

    private Date createdAt;
}
