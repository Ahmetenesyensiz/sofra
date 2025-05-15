package com.example.sofra_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "sales")
public class Sale {

    @Id
    private String id;

    private String orderId;
    private String restaurantId;
    private String tableId;
    private String userId;
    private List<OrderItem> items; // OrderItem zaten mevcut model içinde var
    private double totalPrice;
    private String paymentMethod; // Credit Card, Cash vb.
    private Date paymentDate;
    private Date createdAt;
}
