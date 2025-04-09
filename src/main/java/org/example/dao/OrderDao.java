package org.example.dao;

import org.example.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderDao {
    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Order save(Order order) {
        order.setId(idGenerator.getAndIncrement());
        orders.add(order);
        return order;
    }

    public Order findById(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    public void deleteById(Long id) {
        orders.removeIf(order -> order.getId().equals(id));
    }
}
