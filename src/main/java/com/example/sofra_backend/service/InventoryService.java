package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Inventory;
import com.example.sofra_backend.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        log.info("Fetching all inventory items");
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(String id) {
        log.info("Fetching inventory with ID: {}", id);
        return inventoryRepository.findById(id);
    }

    public List<Inventory> getInventoryByRestaurant(String restaurantId) {
        log.info("Fetching inventory for restaurant ID: {}", restaurantId);
        return inventoryRepository.findByRestaurantId(restaurantId);
    }

    public Optional<Inventory> getInventoryByMenuItem(String menuItemId) {
        log.info("Fetching inventory for menu item ID: {}", menuItemId);
        return inventoryRepository.findByMenuItemId(menuItemId);
    }

    public Inventory createInventory(Inventory inventory) {
        log.info("Creating new inventory item: {}", inventory);
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(String id, Inventory inventory) {
        log.info("Updating inventory with ID: {}", id);
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(String id) {
        log.info("Deleting inventory with ID: {}", id);
        inventoryRepository.deleteById(id);
    }
}
