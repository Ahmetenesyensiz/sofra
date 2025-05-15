package com.example.sofra_backend.repository;

import com.example.sofra_backend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByRestaurantId(String restaurantId);
    List<Order> findByUserId(String userId);
    List<Order> findByTableId(String tableId);
}
