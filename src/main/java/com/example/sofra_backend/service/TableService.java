package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Table;
import com.example.sofra_backend.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<Table> getTableById(String id) {
        return tableRepository.findById(id);
    }

    public List<Table> getTablesByRestaurant(String restaurantId) {
        return tableRepository.findByRestaurantId(restaurantId);
    }

    public Table createTable(Table table) {
        return tableRepository.save(table);
    }

    public void deleteTable(String id) {
        tableRepository.deleteById(id);
    }
}
