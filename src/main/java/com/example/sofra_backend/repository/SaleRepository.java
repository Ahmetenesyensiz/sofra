package com.example.sofra_backend.repository;

import com.example.sofra_backend.model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SaleRepository extends MongoRepository<Sale, String> {
    List<Sale> findByRestaurantId(String restaurantId);
    List<Sale> findByUserId(String userId);
    List<Sale> findByTableId(String tableId);
}
