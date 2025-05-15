package com.example.sofra_backend.controller;

import com.example.sofra_backend.model.Sale;
import com.example.sofra_backend.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public Optional<Sale> getSaleById(@PathVariable String id) {
        return saleService.getSaleById(id);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Sale> getSalesByRestaurant(@PathVariable String restaurantId) {
        return saleService.getSalesByRestaurant(restaurantId);
    }

    @GetMapping("/user/{userId}")
    public List<Sale> getSalesByUser(@PathVariable String userId) {
        return saleService.getSalesByUser(userId);
    }

    @GetMapping("/table/{tableId}")
    public List<Sale> getSalesByTable(@PathVariable String tableId) {
        return saleService.getSalesByTable(tableId);
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable String id) {
        saleService.deleteSale(id);
    }
}
