package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Sale;
import com.example.sofra_backend.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        log.info("Fetching all sales");
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(String id) {
        log.info("Fetching sale with ID: {}", id);
        return saleRepository.findById(id);
    }

    public List<Sale> getSalesByRestaurant(String restaurantId) {
        log.info("Fetching sales for restaurant ID: {}", restaurantId);
        return saleRepository.findByRestaurantId(restaurantId);
    }

    public List<Sale> getSalesByUser(String userId) {
        log.info("Fetching sales for user ID: {}", userId);
        return saleRepository.findByUserId(userId);
    }

    public List<Sale> getSalesByTable(String tableId) {
        log.info("Fetching sales for table ID: {}", tableId);
        return saleRepository.findByTableId(tableId);
    }

    public Sale createSale(Sale sale) {
        log.info("Creating new sale: {}", sale);
        return saleRepository.save(sale);
    }

    public void deleteSale(String id) {
        log.info("Deleting sale with ID: {}", id);
        saleRepository.deleteById(id);
    }
}
