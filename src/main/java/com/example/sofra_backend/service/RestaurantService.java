package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Restaurant;
import com.example.sofra_backend.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        log.info("Fetching all restaurants");
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(String id) {
        log.info("Fetching restaurant with ID: {}", id);
        return restaurantRepository.findById(id);
    }

    public List<Restaurant> getRestaurantsByOwner(String ownerId) {
        log.info("Fetching restaurants for owner ID: {}", ownerId);
        return restaurantRepository.findByOwnerId(ownerId);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        log.info("Creating new restaurant: {}", restaurant);
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(String id) {
        log.info("Deleting restaurant with ID: {}", id);
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> getRestaurantsByOwnerId(String ownerId) {
        return restaurantRepository.findByOwnerId(ownerId);
    }

}
