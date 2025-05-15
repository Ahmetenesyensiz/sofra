package com.example.sofra_backend.controller;

import com.example.sofra_backend.model.Restaurant;
import com.example.sofra_backend.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable String id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Restaurant> getRestaurantsByOwner(@PathVariable String ownerId) {
        return restaurantService.getRestaurantsByOwner(ownerId);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
    }
}
