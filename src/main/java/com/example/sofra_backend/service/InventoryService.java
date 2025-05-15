package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Inventory;
import com.example.sofra_backend.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(String id) {
        return inventoryRepository.findById(id);
    }

    public List<Inventory> getInventoryByRestaurant(String restaurantId) {
        return inventoryRepository.findByRestaurantId(restaurantId);
    }

    public Optional<Inventory> getInventoryByMenuItem(String menuItemId) {
        return inventoryRepository.findByMenuItemId(menuItemId);
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(String id, Inventory inventory) {
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(String id) {
        inventoryRepository.deleteById(id);
    }
}
