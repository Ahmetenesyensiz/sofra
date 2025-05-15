package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Table;
import com.example.sofra_backend.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;

    public List<Table> getAllTables() {
        log.info("Fetching all tables");
        return tableRepository.findAll();
    }

    public Optional<Table> getTableById(String id) {
        log.info("Fetching table with ID: {}", id);
        return tableRepository.findById(id);
    }

    public List<Table> getTablesByRestaurant(String restaurantId) {
        log.info("Fetching tables for restaurant ID: {}", restaurantId);
        return tableRepository.findByRestaurantId(restaurantId);
    }

    public Table createTable(Table table) {
        log.info("Creating new table: {}", table);
        return tableRepository.save(table);
    }

    public void deleteTable(String id) {
        log.info("Deleting table with ID: {}", id);
        tableRepository.deleteById(id);
    }
}
