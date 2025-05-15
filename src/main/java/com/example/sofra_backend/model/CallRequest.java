package com.example.sofra_backend.model;

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

    private String restaurantId;
    private String tableId;
    private String userId;
    private String status; // NEW / ACKNOWLEDGED
    private Date createdAt;
}
