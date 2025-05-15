package com.example.sofra_backend.controller;

import com.example.sofra_backend.model.Inventory;
import com.example.sofra_backend.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable String id) {
        return inventoryService.getInventoryById(id);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Inventory> getInventoryByRestaurant(@PathVariable String restaurantId) {
        return inventoryService.getInventoryByRestaurant(restaurantId);
    }

    @GetMapping("/menuItem/{menuItemId}")
    public Optional<Inventory> getInventoryByMenuItem(@PathVariable String menuItemId) {
        return inventoryService.getInventoryByMenuItem(menuItemId);
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable String id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable String id) {
        inventoryService.deleteInventory(id);
    }
}
