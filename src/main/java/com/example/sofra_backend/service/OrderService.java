package com.example.sofra_backend.service;

import com.example.sofra_backend.model.Order;
import com.example.sofra_backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        log.info("Fetching all orders");
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String id) {
        log.info("Fetching order with ID: {}", id);
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByRestaurant(String restaurantId) {
        log.info("Fetching orders for restaurant ID: {}", restaurantId);
        return orderRepository.findByRestaurantId(restaurantId);
    }

    public List<Order> getOrdersByUser(String userId) {
        log.info("Fetching orders for user ID: {}", userId);
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getOrdersByTable(String tableId) {
        log.info("Fetching orders for table ID: {}", tableId);
        return orderRepository.findByTableId(tableId);
    }

    public Order createOrder(Order order) {
        log.info("Creating new order: {}", order);
        return orderRepository.save(order);
    }

    public void deleteOrder(String id) {
        log.info("Deleting order with ID: {}", id);
        orderRepository.deleteById(id);
    }
}
