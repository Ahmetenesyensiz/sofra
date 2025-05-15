package com.example.sofra_backend.repository;

import com.example.sofra_backend.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    List<Inventory> findByRestaurantId(String restaurantId);
    Optional<Inventory> findByMenuItemId(String menuItemId);
}
