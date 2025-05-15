package com.example.sofra_backend.controller;

import com.example.sofra_backend.model.MenuItem;
import com.example.sofra_backend.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menuItems")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public Optional<MenuItem> getMenuItemById(@PathVariable String id) {
        return menuItemService.getMenuItemById(id);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItem> getMenuItemsByRestaurant(@PathVariable String restaurantId) {
        return menuItemService.getMenuItemsByRestaurant(restaurantId);
    }

    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.createMenuItem(menuItem);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable String id) {
        menuItemService.deleteMenuItem(id);
    }
}
