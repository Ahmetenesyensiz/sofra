package com.example.sofra_backend.repository;

import com.example.sofra_backend.model.CallRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CallRequestRepository extends MongoRepository<CallRequest, String> {
    List<CallRequest> findByRestaurantId(String restaurantId);
    List<CallRequest> findByTableId(String tableId);
}
