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
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String restaurantId;
    private String tableId;
    private String userId;

    // Sipariş ürünleri
    private List<OrderItem> items;

    private String status; // PENDING / PREPARING / READY / COMPLETED / CANCELED
    private double totalPrice;
    private Date createdAt;
}
