package com.example.sofra_backend.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Restaurant ID is mandatory")
    private String restaurantId;

    @NotBlank(message = "Table ID is mandatory")
    private String tableId;

    @NotBlank(message = "User ID is mandatory")
    private String userId;

    // Sipariş ürünleri
    private List<OrderItem> items;  // List boş olabilir (kontrol istersen Service katmanında yaparız)

    @NotBlank(message = "Order status is mandatory")
    private String status; // PENDING / PREPARING / READY / COMPLETED / CANCELED

    @Min(value = 0, message = "Total price must be at least 0")
    private double totalPrice;

    private Date createdAt;
}
