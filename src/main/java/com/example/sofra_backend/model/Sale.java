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
@Document(collection = "sales")
public class Sale {

    @Id
    private String id;

    @NotBlank(message = "Order ID is mandatory")
    private String orderId;

    @NotBlank(message = "Restaurant ID is mandatory")
    private String restaurantId;

    @NotBlank(message = "Table ID is mandatory")
    private String tableId;

    @NotBlank(message = "User ID is mandatory")
    private String userId;

    private List<OrderItem> items; // OrderItem zaten mevcut model içinde var

    @Min(value = 0, message = "Total price must be at least 0")
    private double totalPrice;

    @NotBlank(message = "Payment method is mandatory")
    private String paymentMethod; // Credit Card, Cash vb.

    private Date paymentDate;
    private Date createdAt;
}
