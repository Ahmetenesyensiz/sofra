package com.example.sofra_backend.service;

import com.example.sofra_backend.model.MenuItem;
import com.example.sofra_backend.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        log.info("Fetching all menu items");
        return menuItemRepository.findAll();
    }

    public Optional<MenuItem> getMenuItemById(String id) {
        log.info("Fetching menu item with ID: {}", id);
        return menuItemRepository.findById(id);
    }

    public List<MenuItem> getMenuItemsByRestaurant(String restaurantId) {
        log.info("Fetching menu items for restaurant ID: {}", restaurantId);
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
        log.info("Creating new menu item: {}", menuItem);
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(String id) {
        log.info("Deleting menu item with ID: {}", id);
        menuItemRepository.deleteById(id);
    }
}
