package com.example.sofra_backend.repository;

import com.example.sofra_backend.model.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TableRepository extends MongoRepository<Table, String> {
    List<Table> findByRestaurantId(String restaurantId);
}
