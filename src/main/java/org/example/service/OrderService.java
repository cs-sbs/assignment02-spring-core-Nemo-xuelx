package org.example.service;

import org.example.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(String customerName, String product, double amount);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    void cancelOrder(Long id);
}