package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Sale;
import com.example.sofra_backend.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(String id) {
        return saleRepository.findById(id);
    }

    public List<Sale> getSalesByRestaurant(String restaurantId) {
        return saleRepository.findByRestaurantId(restaurantId);
    }

    public List<Sale> getSalesByUser(String userId) {
        return saleRepository.findByUserId(userId);
    }

    public List<Sale> getSalesByTable(String tableId) {
        return saleRepository.findByTableId(tableId);
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public void deleteSale(String id) {
        saleRepository.deleteById(id);
    }
}
