package com.example.sofra_backend.controller;

import com.example.sofra_backend.model.Table;
import com.example.sofra_backend.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tables")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping
    public List<Table> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/{id}")
    public Optional<Table> getTableById(@PathVariable String id) {
        return tableService.getTableById(id);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Table> getTablesByRestaurant(@PathVariable String restaurantId) {
        return tableService.getTablesByRestaurant(restaurantId);
    }

    @PostMapping
    public Table createTable(@RequestBody Table table) {
        return tableService.createTable(table);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable String id) {
        tableService.deleteTable(id);
    }
}
