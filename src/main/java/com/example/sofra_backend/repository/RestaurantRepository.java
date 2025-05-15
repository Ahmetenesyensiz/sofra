package com.example.sofra_backend.repository;

import com.example.sofra_backend.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    List<Restaurant> findByOwnerId(String ownerId);
}
